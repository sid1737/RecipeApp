package com.example.recipeapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.recipeapp.domain.models.Recipe
import com.example.recipeapp.ui.recipeDetailsScreen.RecipeDetailScreen
import com.example.recipeapp.ui.recipeListScreen.RecipeListScreen
import kotlin.reflect.typeOf

@Composable
fun RecipeAppNavigation(
    modifier: Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = ScreenNames.RecipeListScreen
    ) {
        composable<ScreenNames.RecipeListScreen> {
            RecipeListScreen(
                navHostController = navController
            )
        }
        composable<ScreenNames.RecipeDetailScreen> (
            typeMap = mapOf(
                typeOf<Recipe>() to CustomNavType.RecipeType
            )
        ) {
            val arguments = it.toRoute<ScreenNames.RecipeDetailScreen>()
            RecipeDetailScreen(
                recipe = arguments.recipe
            )
        }
    }
}