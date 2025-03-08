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
import com.example.recipeapp.domain.models.Ingredient
import com.example.recipeapp.ui.theme.PaddingMedium

@Composable
fun RecipeIngredientList(
    ingredientList: List<Ingredient>,
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
                        bottom = PaddingMedium
                    ),
                horizontalArrangement = Arrangement.spacedBy(PaddingMedium),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = null
                )
                Text(
                    text = ingredient.ingredient,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                )
            }
        }
    }
}