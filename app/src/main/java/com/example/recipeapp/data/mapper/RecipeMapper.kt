package com.example.recipeapp.data.mapper

import com.example.recipeapp.data.model.IngredientEntity
import com.example.recipeapp.data.model.RecipeDetailsEntity
import com.example.recipeapp.data.model.RecipeEntityList
import com.example.recipeapp.domain.models.Ingredient
import com.example.recipeapp.domain.models.Recipe
import com.example.recipeapp.domain.models.RecipeDetails

fun RecipeEntityList.toRecipeList(): List<Recipe> {
    return this.recipes.map { recipe ->
        Recipe(
            dynamicDescription = recipe.dynamicDescription,
            dynamicThumbnail = recipe.dynamicThumbnail,
            dynamicThumbnailAlt = recipe.dynamicThumbnailAlt,
            dynamicTitle = recipe.dynamicTitle,
            ingredients = mapIngredientEntityToIngredient(recipe.ingredients),
            recipeDetails = mapRecipeDetailsEntityToRecipeDetails(recipe.recipeDetails)
        )
    }
}

private fun mapIngredientEntityToIngredient(ingredientEntityList: List<IngredientEntity>): List<Ingredient> {
    return ingredientEntityList.map { ingredientEntity ->
        Ingredient(
            ingredient = ingredientEntity.ingredient
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