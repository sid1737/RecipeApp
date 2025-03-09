package com.example.recipeapp.ui.recipeListScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipeapp.ui.theme.Dimens.SpaceMedium
import com.example.recipeapp.ui.uiState.RecipeUiState

@Composable
fun RecipeList(
    numberOfColumns: Int,
    modifier: Modifier = Modifier,
    recipes: List<RecipeUiState>,
    onRecipeCLick: (RecipeUiState) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(numberOfColumns),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(SpaceMedium),
        horizontalArrangement = Arrangement.spacedBy(SpaceMedium),
        verticalArrangement = Arrangement.spacedBy(SpaceMedium)
    ) {
        items(
            recipes,
            key = { recipe -> recipe.recipeName.hashCode() }
        ) { recipe ->
            RecipeCard(
                recipe = recipe,
                onRecipeClick = onRecipeCLick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeList() {
    RecipeList(
        numberOfColumns = 2,
        recipes = listOf(
            getDummyRecipe()
        ),
        onRecipeCLick = {}
    )
}

private fun getDummyRecipe(): RecipeUiState {
    return RecipeUiState(
        recipeDescription = "recipe description",
        recipeImageUrl = "recipe image url",
        alternativeTextForImage = "alternative text for image",
        recipeName = "recipe name",
        ingredients = listOf("recipe ingredients"),
        totalServes = "8",
        totalCookingTimeAsString = "4h 30m",
        totalCookingTimeInHoursAndMinutes = Pair(4,2),
        totalPrepTimeAsString = "15m",
        totalPreparationTimeInHoursAndMinutes = Pair(6,2)
    )
}