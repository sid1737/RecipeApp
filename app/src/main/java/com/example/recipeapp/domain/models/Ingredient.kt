package com.example.recipeapp.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Ingredient(
    val ingredient: String
)