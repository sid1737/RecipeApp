package com.example.recipeapp.ui.recipeListScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.SubcomposeAsyncImage
import com.example.recipeapp.R
import com.example.recipeapp.domain.models.Ingredient
import com.example.recipeapp.domain.models.Recipe
import com.example.recipeapp.domain.models.RecipeDetails
import com.example.recipeapp.ui.theme.SpaceSmall

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    recipe: Recipe,
    onRecipeClick: (Recipe) -> Unit
) {
    val contentDescriptionForRecipe = stringResource(R.string.recipe_name_content_description) + recipe.dynamicTitle
    Column(
        modifier = modifier
            .fillMaxSize()
            .semantics {
                contentDescription = contentDescriptionForRecipe
            }
            .clickable {
                onRecipeClick(recipe)
            },
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            SubcomposeAsyncImage(
                model = recipe.dynamicThumbnail,
                contentDescription = null,
                loading = {
                    CircularProgressIndicator()
                }
            )
        }
        Spacer(
            modifier = Modifier.height(SpaceSmall)
        )
        Text(
            text = stringResource(R.string.recipe_title),
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.labelSmall
        )
        Spacer(
            modifier = Modifier.height(SpaceSmall)
        )
        Text(
            text = recipe.dynamicTitle,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeCard() {
    RecipeCard(
        recipe = getDummyRecipe(),
        onRecipeClick = {}
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