package com.example.recipeapp.ui.recipeDetailsScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipeapp.ui.theme.Dimens.SpaceMedium

@Composable
fun RecipeIngredientList(
    ingredientList: List<String>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        ingredientList.forEachIndexed { _ , ingredient ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        bottom = SpaceMedium
                    ),
                horizontalArrangement = Arrangement.spacedBy(SpaceMedium),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null
                )
                Text(
                    text = ingredient,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewRecipeIngredientList() {
    RecipeIngredientList(
        ingredientList = listOf(
            "Ingredient1"
        )
    )
}