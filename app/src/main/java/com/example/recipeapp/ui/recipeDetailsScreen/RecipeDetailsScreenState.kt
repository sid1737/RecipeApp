package com.example.recipeapp.ui.recipeDetailsScreen

import com.example.recipeapp.domain.models.Recipe

sealed interface RecipeDetailsScreenState {
    data object Loading: RecipeDetailsScreenState
    data object Error: RecipeDetailsScreenState
    data class Success(val recipe: Recipe): RecipeDetailsScreenState
}