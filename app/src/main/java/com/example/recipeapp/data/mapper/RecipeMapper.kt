package com.example.recipeapp.data.mapper

import coil.map.Mapper
import coil.request.Options
import com.example.recipeapp.data.model.IngredientEntity
import com.example.recipeapp.data.model.RecipeDetailsEntity
import com.example.recipeapp.data.model.RecipeEntity
import com.example.recipeapp.domain.models.Ingredient
import com.example.recipeapp.domain.models.Recipe
import com.example.recipeapp.domain.models.RecipeDetails
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipeMapper @Inject constructor() : Mapper<RecipeEntity, Recipe> {
    override fun map(data: RecipeEntity, options: Options): Recipe {
        return Recipe(
            dynamicDescription = data.dynamicDescription,
            dynamicThumbnail = data.dynamicThumbnail,
            dynamicThumbnailAlt = data.dynamicThumbnailAlt,
            dynamicTitle = data.dynamicTitle,
            ingredients = mapIngredientEntityToIngredient(data.ingredients),
            recipeDetails = mapRecipeDetailsEntityToRecipeDetails(data.recipeDetails)
        )
    }

    private fun mapIngredientEntityToIngredient(ingredientEntity: List<IngredientEntity>): List<Ingredient> {
        return ingredientEntity.map {
            Ingredient(
                ingredient = it.ingredient
            )
        }
    }

    private fun mapRecipeDetailsEntityToRecipeDetails(recipeDetailsEntity: RecipeDetailsEntity): RecipeDetails {
        return RecipeDetails(
            amountLabel = recipeDetailsEntity.amountLabel,
            amountNumber = recipeDetailsEntity.amountNumber,
            cookTimeAsMinutes = recipeDetailsEntity.cookTimeAsMinutes,
            cookingLabel = recipeDetailsEntity.cookingLabel,
            cookingTime = recipeDetailsEntity.cookingTime,
            prepLabel = recipeDetailsEntity.prepLabel,
            prepNote = recipeDetailsEntity.prepNote,
            prepTime = recipeDetailsEntity.prepTime,
            prepTimeAsMinutes = recipeDetailsEntity.prepTimeAsMinutes
        )
    }
}