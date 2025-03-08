package com.example.recipeapp.ui.recipeDetailsScreen

import androidx.lifecycle.ViewModel
import com.example.recipeapp.domain.models.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecipeDetailsViewModel: ViewModel() {
    private val _recipeDetailsScreenUiState = MutableStateFlow<RecipeDetailsScreenState>(RecipeDetailsScreenState.Loading)
    val recipeDetailsScreenState = _recipeDetailsScreenUiState.asStateFlow()

    fun loadRecipe(recipe: Recipe) {
        _recipeDetailsScreenUiState.value = RecipeDetailsScreenState.Success(recipe)
    }
}