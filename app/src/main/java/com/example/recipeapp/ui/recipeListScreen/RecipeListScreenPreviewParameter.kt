package com.example.recipeapp.ui.recipeListScreen

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.recipeapp.ui.uiState.RecipeUiState

class RecipeListScreenPreviewParameter : PreviewParameterProvider<RecipeListScreenState> {
    override val values: Sequence<RecipeListScreenState>
        get() = sequenceOf(
            RecipeListScreenState.Loading,
            RecipeListScreenState.Error,
            RecipeListScreenState.Success(
                listOf(
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
        )
}