package com.example.recipeapp.domain.repository

import com.example.recipeapp.domain.models.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    suspend fun getRecipe(): Flow<List<Recipe>>
}