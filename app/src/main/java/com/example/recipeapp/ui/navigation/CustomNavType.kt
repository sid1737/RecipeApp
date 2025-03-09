package com.example.recipeapp.ui.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.example.recipeapp.ui.uiState.RecipeUiState
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object CustomNavType {
    val RecipeType = object : NavType<RecipeUiState>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): RecipeUiState? {
            return Json.decodeFromString(bundle.getString(key) ?: "")
        }

        override fun parseValue(value: String): RecipeUiState {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun put(bundle: Bundle, key: String, value: RecipeUiState) {
            bundle.putString(key, Json.encodeToString(value))
        }

        override fun serializeAsValue(value: RecipeUiState): String {
            return Uri.encode(Json.encodeToString(value))
        }
    }
}