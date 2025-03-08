package com.example.recipeapp.ui.recipeListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.domain.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<RecipeListScreenState>(RecipeListScreenState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        fetchRecipeData()
    }

    private fun fetchRecipeData() {
        viewModelScope.launch {
            recipeRepository.getRecipe()
                .onStart {
                    _uiState.value = RecipeListScreenState.Loading
                }.catch {
                    _uiState.value = RecipeListScreenState.Error
                }.collect { recipes ->
                    _uiState.value = RecipeListScreenState.Success(recipes)
                }
        }
    }

    fun retryFetchingDataFromFile() {
        fetchRecipeData()
    }
}