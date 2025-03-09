package com.example.recipeapp.ui.recipeDetailsScreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RecipeDetailScreenTitle(
    modifier: Modifier = Modifier,
    recipeScreenTitle: String
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .semantics {
                contentDescription = recipeScreenTitle
            },
        text = recipeScreenTitle,
        style = MaterialTheme.typography.displayLarge,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun PreviewRecipeDetailScreenTitle() {
    RecipeDetailScreenTitle(
        recipeScreenTitle = "Recipe Screen Title"
    )
}