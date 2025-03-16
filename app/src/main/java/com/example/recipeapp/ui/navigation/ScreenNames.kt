package com.example.recipeapp.ui.navigation

import com.example.recipeapp.ui.uiState.RecipeUiState
import kotlinx.serialization.Serializable

sealed class ScreenNames {
    @Serializable
    data object RecipeListScreen : ScreenNames()

    @Serializable
    data class RecipeDetailScreen(val recipe: RecipeUiState) : ScreenNames()
}