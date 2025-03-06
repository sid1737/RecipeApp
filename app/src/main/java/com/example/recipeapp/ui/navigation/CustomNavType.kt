package com.example.recipeapp.ui.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.example.recipeapp.domain.models.Recipe
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object CustomNavType {
    val RecipeType = object : NavType<Recipe>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): Recipe? {
            return Json.decodeFromString(bundle.getString(key) ?: "")
        }

        override fun parseValue(value: String): Recipe {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun put(bundle: Bundle, key: String, value: Recipe) {
            bundle.putString(key, Json.encodeToString(value))
        }

        override fun serializeAsValue(value: Recipe): String {
            return Uri.encode(Json.encodeToString(value))
        }
    }
}