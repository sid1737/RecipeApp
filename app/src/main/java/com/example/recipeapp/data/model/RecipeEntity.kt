package com.example.recipeapp.data.model

data class RecipeEntity(
    val dynamicDescription: String,
    val dynamicThumbnail: String,
    val dynamicThumbnailAlt: String,
    val dynamicTitle: String,
    val ingredients: List<IngredientEntity>,
    val recipeDetails: RecipeDetailsEntity
)