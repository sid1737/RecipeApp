package com.example.recipeapp.ui.recipeDetailsScreen

import androidx.lifecycle.ViewModel
import com.example.recipeapp.ui.uiState.RecipeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecipeDetailsViewModel: ViewModel() {
    private val _recipeDetailsScreenUiState = MutableStateFlow<RecipeDetailsScreenState>(RecipeDetailsScreenState.Loading)
    val recipeDetailsScreenState = _recipeDetailsScreenUiState.asStateFlow()

    fun loadRecipe(recipe: RecipeUiState) {
        _recipeDetailsScreenUiState.value = RecipeDetailsScreenState.Success(recipe)
    }
}