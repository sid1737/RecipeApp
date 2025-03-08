package com.example.recipeapp.data.repository

import android.content.Context
import coil.request.Options
import com.example.recipeapp.data.mapper.RecipeMapper
import com.example.recipeapp.data.model.RecipeEntityList
import com.example.recipeapp.dispatchers.AppDispatchers
import com.example.recipeapp.domain.models.Recipe
import com.example.recipeapp.domain.repository.RecipeRepository
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.InputStreamReader
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val recipeMapper: RecipeMapper,
    private val appDispatchers: AppDispatchers,
    private val gson: Gson
) : RecipeRepository {
    override fun getRecipe(): Flow<List<Recipe>> {
        return flow {
            val jsonString = context.assets.open("recipes.json")
            val inputStream = InputStreamReader(jsonString)
            val listOfRecipes = gson.fromJson(inputStream, RecipeEntityList::class.java)
            emit(recipeMapper.map(listOfRecipes, Options(context)))
        }.catch {
            throw it
        }.flowOn(appDispatchers.io)
    }
}