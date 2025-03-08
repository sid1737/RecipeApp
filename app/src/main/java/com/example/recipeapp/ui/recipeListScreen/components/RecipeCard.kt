package com.example.recipeapp.ui.recipeListScreen.components

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
import com.example.recipeapp.ui.theme.SpaceSmall

@Composable
fun RecipeCard(
    recipeName: String,
    recipeUrl: String,
    modifier: Modifier = Modifier
) {
    val contentDescriptionForRecipe = stringResource(R.string.recipe_name_content_description) + recipeName
    Column(
        modifier = modifier
            .fillMaxSize()
            .semantics {
                contentDescription = contentDescriptionForRecipe
            },
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            SubcomposeAsyncImage(
                model = recipeUrl,
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
            text = recipeName,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeCard() {
    RecipeCard(
        recipeName = stringResource(R.string.recipe_name_string_preview),
        recipeUrl = stringResource(R.string.recipe_url_string_preview)
    )
}