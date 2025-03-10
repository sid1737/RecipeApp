package com.example.recipeapp.ui.recipeListScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.SubcomposeAsyncImage
import com.example.recipeapp.R
import com.example.recipeapp.ui.theme.Dimens.SpaceExtraSmall
import com.example.recipeapp.ui.uiState.RecipeUiState

@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    recipe: RecipeUiState,
    onRecipeClick: (RecipeUiState) -> Unit
) {
    val contentDescriptionForRecipe = stringResource(R.string.recipe_name_content_description) + recipe.recipeName

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
        SubcomposeAsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = recipe.recipeImageUrl,
            contentDescription = null,
            loading = {
                CircularProgressIndicator()
            },
            contentScale = ContentScale.Crop
        )
        Spacer(
            modifier = Modifier.height(SpaceExtraSmall)
        )
        Text(
            modifier = Modifier.clearAndSetSemantics {},
            text = stringResource(R.string.recipe_title),
            color = Color.Red,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.labelSmall
        )
        Spacer(
            modifier = Modifier.height(SpaceExtraSmall)
        )
        Text(
            modifier = Modifier.clearAndSetSemantics {},
            text = recipe.recipeName,
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