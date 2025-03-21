package com.example.recipeapp.ui.recipeListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipeapp.dispatchers.AppDispatchers
import com.example.recipeapp.domain.repository.RecipeRepository
import com.example.recipeapp.ui.uiState.RecipeUiState
import com.example.recipeapp.ui.uiState.toRecipeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private val recipeRepository: RecipeRepository,
    private val appDispatchers: AppDispatchers
) : ViewModel() {

    private val _uiState = MutableStateFlow<RecipeListScreenState>(RecipeListScreenState.Loading)
    val recipeListUiState = _uiState.asStateFlow()

    private val _recipeListScreenEvents = MutableSharedFlow<RecipeListScreenEvents>()
    val recipeListScreenEvents = _recipeListScreenEvents.asSharedFlow()

    init {
        fetchRecipeData()
    }

    private fun fetchRecipeData() {
        viewModelScope.launch(appDispatchers.io) {
            recipeRepository.getRecipe().map { listOfRecipes ->
                listOfRecipes.map {
                    it.toRecipeUiState()
                }
            }
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

    fun navigateToRecipeDetailsScreen(recipe: RecipeUiState) {
        viewModelScope.launch(appDispatchers.io) {
            _recipeListScreenEvents.emit(RecipeListScreenEvents.NavigateToRecipeDetailsScreen(recipe))
        }
    }
}