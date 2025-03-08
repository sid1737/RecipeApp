package com.example.recipeapp.ui.recipeListScreen

import com.example.recipeapp.domain.models.Recipe

sealed interface RecipeListScreenEvents {
    data class NavigateToRecipeDetailsScreen(val recipe: Recipe): RecipeListScreenEvents
}