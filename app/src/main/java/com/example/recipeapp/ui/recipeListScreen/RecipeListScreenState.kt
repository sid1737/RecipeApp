package com.example.recipeapp.ui.recipeListScreen

import com.example.recipeapp.ui.uiState.RecipeUiState

sealed interface RecipeListScreenState {
    data object Loading: RecipeListScreenState
    data object Error: RecipeListScreenState
    data class Success(val recipes: List<RecipeUiState>): RecipeListScreenState
}