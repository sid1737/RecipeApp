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
import com.example.recipeapp.domain.models.Ingredient
import com.example.recipeapp.domain.models.Recipe
import com.example.recipeapp.domain.models.RecipeDetails
import com.example.recipeapp.ui.theme.PaddingMedium

@Composable
fun RecipeList(
    numberOfColumns: Int,
    modifier: Modifier = Modifier,
    recipes: List<Recipe>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(numberOfColumns),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(PaddingMedium),
        horizontalArrangement = Arrangement.spacedBy(PaddingMedium),
        verticalArrangement = Arrangement.spacedBy(PaddingMedium)
    ) {
        items(
            recipes,
            key = { recipe -> recipe.dynamicTitle.hashCode() }
        ) { recipe ->
            RecipeCard(
                recipeName = recipe.dynamicTitle,
                recipeUrl = recipe.dynamicThumbnail
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
        )
    )
}

private fun getDummyRecipe(): Recipe {
    return Recipe(
        dynamicDescription = "dynamic description",
        dynamicThumbnail = "dynamic thumbnail",
        dynamicThumbnailAlt = "dynamic thumbnail alt",
        dynamicTitle = "dynamic title",
        ingredients = listOf(
            Ingredient(
                ingredient = "ingredient"
            )
        ),
        recipeDetails = RecipeDetails(
            amountLabel = "amount label",
            amountNumber = 10,
            cookTimeAsMinutes = 20,
            cookingLabel = "cooking label",
            cookingTime = "cooking time",
            prepLabel = "prep label",
            prepNote = "prep note",
            prepTime = "prep time",
            prepTimeAsMinutes = 40
        )
    )
}