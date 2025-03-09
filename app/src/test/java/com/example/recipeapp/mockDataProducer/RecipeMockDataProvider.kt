package com.example.recipeapp.mockDataProducer

import com.example.recipeapp.data.model.IngredientEntity
import com.example.recipeapp.data.model.RecipeDetailsEntity
import com.example.recipeapp.data.model.RecipeEntity
import com.example.recipeapp.data.model.RecipeEntityList
import com.example.recipeapp.domain.models.Ingredient
import com.example.recipeapp.domain.models.Recipe
import com.example.recipeapp.domain.models.RecipeDetails
import com.example.recipeapp.ui.uiState.RecipeUiState

object RecipeMockDataProvider {

    fun getMockRecipeEntityList(): RecipeEntityList {
        return RecipeEntityList(
            recipes = listOf(
                RecipeEntity(
                    dynamicDescription = "dynamic description",
                    dynamicThumbnail = "dynamic thumbnail",
                    dynamicThumbnailAlt = "dynamic thumbnail alt",
                    dynamicTitle = "dynamic title",
                    ingredients = listOf(
                        IngredientEntity(
                            ingredient = "ingredient"
                        )
                    ),
                    recipeDetails = RecipeDetailsEntity(
                        amountLabel = "amount label",
                        amountNumber = 9,
                        cookTimeAsMinutes = 120,
                        cookingLabel = "cooking label",
                        cookingTime = "4h 20m",
                        prepLabel = "prep label",
                        prepNote = "prep note",
                        prepTime = "20m",
                        prepTimeAsMinutes = 40
                    )
                )
            )
        )
    }

    fun getMockRecipeList(): List<Recipe> {
        return listOf(
            Recipe(
                dynamicDescription = "dynamic description",
                dynamicThumbnail = "dynamic thumbnail",
                dynamicThumbnailAlt = "dynamic thumbnail alt",
                dynamicTitle = "dynamic title",
                ingredients = listOf(
                    Ingredient(
                        ingredient = "ingredient"
                    )
                ),
                recipeDetails = RecipeDetails(
                    amountLabel = "amount label",
                    amountNumber = 9,
                    cookTimeAsMinutes = 120,
                    cookingLabel = "cooking label",
                    cookingTime = "4h 20m",
                    prepLabel = "prep label",
                    prepNote = "prep note",
                    prepTime = "20m",
                    prepTimeAsMinutes = 40
                )
            )
        )
    }

    fun getMockRecipeUiState(): RecipeUiState {
        return RecipeUiState(
            recipeDescription = "recipe description",
            recipeImageUrl = "recipe image url",
            alternativeTextForImage = "recipe alternative text image",
            recipeName = "recipe name",
            ingredients = listOf(
                "ingredient"
            ),
            totalServes = "8",
            totalCookingTimeAsString = "4h 20m",
            totalCookingTimeInHoursAndMinutes = Pair(4, 20),
            totalPrepTimeAsString = "3h 20m",
            totalPreparationTimeInHoursAndMinutes = Pair(3, 20)
        )
    }
}