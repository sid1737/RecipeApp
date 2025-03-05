package com.example.recipeapp.domain.repository

import com.example.recipeapp.domain.models.Recipe

interface RecipeRepository {
    suspend fun getRecipe(): List<Recipe>
}