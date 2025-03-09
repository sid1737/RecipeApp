package com.example.recipeapp.ui.uiState

import com.example.recipeapp.data.Constants.THUMBNAIL_URL
import com.example.recipeapp.domain.models.Recipe
import com.example.recipeapp.ui.utils.splitTotalMinutesIntoHoursAndMinutes

fun Recipe.toRecipeUiState(): RecipeUiState {
    return RecipeUiState(
        recipeName = this.dynamicTitle,
        recipeDescription = this.dynamicDescription,
        recipeImageUrl = THUMBNAIL_URL + this.dynamicThumbnail,
        alternativeTextForImage = this.dynamicThumbnailAlt,
        totalServes = this.recipeDetails.amountNumber.toString(),
        ingredients = this.ingredients.map { listOfIngredients ->
            listOfIngredients.ingredient
        },
        totalCookingTimeAsString = this.recipeDetails.cookingTime,
        totalCookingTimeInHoursAndMinutes = splitTotalMinutesIntoHoursAndMinutes(this.recipeDetails.cookTimeAsMinutes),
        totalPrepTimeAsString = this.recipeDetails.prepTime,
        totalPreparationTimeInHoursAndMinutes = splitTotalMinutesIntoHoursAndMinutes(this.recipeDetails.prepTimeAsMinutes)
    )
}