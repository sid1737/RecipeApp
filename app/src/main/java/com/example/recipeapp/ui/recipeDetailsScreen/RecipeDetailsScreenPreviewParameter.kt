package com.example.recipeapp.ui.recipeDetailsScreen

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.recipeapp.ui.uiState.RecipeUiState

class RecipeDetailsScreenPreviewParameter : PreviewParameterProvider<RecipeDetailsScreenState> {
    override val values: Sequence<RecipeDetailsScreenState>
        get() = sequenceOf(
            RecipeDetailsScreenState.Loading,
            RecipeDetailsScreenState.Error,
            RecipeDetailsScreenState.Success(
                RecipeUiState(
                    recipeDescription = "recipe description",
                    recipeImageUrl = "recipe image url",
                    alternativeTextForImage = "alternative text for image",
                    recipeName = "recipe name",
                    ingredients = listOf("recipe ingredients"),
                    totalServes = "8",
                    totalCookingTimeAsString = "4h 30m",
                    totalCookingTimeInHoursAndMinutes = Pair(4, 2),
                    totalPrepTimeAsString = "15m",
                    totalPreparationTimeInHoursAndMinutes = Pair(6, 2)
                )
            )
        )

}