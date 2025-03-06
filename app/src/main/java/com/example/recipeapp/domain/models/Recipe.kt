package com.example.recipeapp.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    val dynamicDescription: String,
    val dynamicThumbnail: String,
    val dynamicThumbnailAlt: String,
    val dynamicTitle: String,
    val ingredients: List<Ingredient>,
    val recipeDetails: RecipeDetails
)