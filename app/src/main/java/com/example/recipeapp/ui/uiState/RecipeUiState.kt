package com.example.recipeapp.ui.uiState

import kotlinx.serialization.Serializable

@Serializable
data class RecipeUiState(
    val recipeDescription: String,
    val recipeImageUrl: String,
    val alternativeTextForImage: String,
    val recipeName: String,
    val ingredients: List<String>,
    val totalServes: String,
    val totalCookingTimeAsString: String,
    val totalCookingTimeInHoursAndMinutes: Pair<Int, Int>,
    val totalPrepTimeAsString: String,
    val totalPreparationTimeInHoursAndMinutes: Pair<Int, Int>
)
