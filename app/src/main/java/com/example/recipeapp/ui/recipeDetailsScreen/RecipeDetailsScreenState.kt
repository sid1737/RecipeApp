package com.example.recipeapp.ui.recipeDetailsScreen

import com.example.recipeapp.ui.uiState.RecipeUiState

sealed interface RecipeDetailsScreenState {
    data object Loading: RecipeDetailsScreenState
    data object Error: RecipeDetailsScreenState
    data class Success(val recipe: RecipeUiState): RecipeDetailsScreenState
}