package com.example.recipeapp.ui.recipeListScreen

import com.example.recipeapp.domain.models.Recipe

sealed interface RecipeListScreenState {
    data object Loading: RecipeListScreenState
    data object Error: RecipeListScreenState
    data class Success(val recipes: List<Recipe>): RecipeListScreenState
}