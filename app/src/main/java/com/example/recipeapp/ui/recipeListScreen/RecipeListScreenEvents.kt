package com.example.recipeapp.ui.recipeListScreen

import com.example.recipeapp.ui.uiState.RecipeUiState

sealed interface RecipeListScreenEvents {
    data class NavigateToRecipeDetailsScreen(val recipe: RecipeUiState): RecipeListScreenEvents
}