package com.example.recipeapp.domain.models

data class RecipeDetails(
    val amountLabel: String,
    val amountNumber: Int,
    val cookTimeAsMinutes: Int,
    val cookingLabel: String,
    val cookingTime: String,
    val prepLabel: String,
    val prepNote: String?,
    val prepTime: String,
    val prepTimeAsMinutes: Int
)