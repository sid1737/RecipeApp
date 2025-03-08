package com.example.recipeapp.ui.recipeDetailsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.SubcomposeAsyncImage
import com.example.recipeapp.R
import com.example.recipeapp.domain.models.Ingredient
import com.example.recipeapp.domain.models.Recipe
import com.example.recipeapp.domain.models.RecipeDetails
import com.example.recipeapp.ui.commonComponents.LoadingIndicator
import com.example.recipeapp.ui.commonComponents.ErrorScreen
import com.example.recipeapp.ui.recipeDetailsScreen.components.RecipeIngredientList
import com.example.recipeapp.ui.recipeDetailsScreen.components.RecipePrepDetailsComponent
import com.example.recipeapp.ui.theme.PaddingLarge
import com.example.recipeapp.ui.theme.PaddingMedium

@Composable
fun RecipeDetailScreen(
    modifier: Modifier = Modifier,
    recipeDetailScreenViewModel: RecipeDetailsViewModel = hiltViewModel(),
    recipe: Recipe
) {
    LaunchedEffect(recipe) {
        recipeDetailScreenViewModel.loadRecipe(recipe)
    }

    val recipeDetailsStateValue =
        recipeDetailScreenViewModel.recipeDetailsScreenState.collectAsStateWithLifecycle().value

    RecipeDetailsScreen(recipeDetailsStateValue, modifier)
}

@Composable
private fun RecipeDetailsScreen(
    recipeDetailsStateValue: RecipeDetailsScreenState,
    modifier: Modifier = Modifier
) {
    when (recipeDetailsStateValue) {
        is RecipeDetailsScreenState.Success -> {
            GetRecipeDetailScreenStateComponents(modifier, recipeDetailsStateValue)
        }

        RecipeDetailsScreenState.Error -> {
            ErrorScreen(
                errorMessage = stringResource(R.string.error_message_recipe_details_screen)
            )
        }

        RecipeDetailsScreenState.Loading -> {
            LoadingIndicator()
        }
    }
}

@Composable
private fun GetRecipeDetailScreenStateComponents(
    modifier: Modifier,
    recipeDetailsState: RecipeDetailsScreenState.Success
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(PaddingMedium)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .semantics {
                    contentDescription = recipeDetailsState.recipe.dynamicTitle
                },
            text = recipeDetailsState.recipe.dynamicTitle,
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(
            modifier = Modifier.height(PaddingMedium)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .semantics {
                    contentDescription = recipeDetailsState.recipe.dynamicDescription
                },
            text = recipeDetailsState.recipe.dynamicDescription,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal
        )
        Spacer(
            modifier = Modifier.height(PaddingMedium)
        )
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier
                    .fillMaxSize(),
                model = recipeDetailsState.recipe.dynamicThumbnail,
                contentDescription = null,
                loading = {
                    CircularProgressIndicator()
                },
                contentScale = ContentScale.Crop
            )
        }
        Spacer(
            modifier = Modifier.height(PaddingMedium)
        )
        RecipePrepDetailsComponent(
            totalServes = recipeDetailsState.recipe.recipeDetails.amountNumber.toString(),
            prepTimeAsString = recipeDetailsState.recipe.recipeDetails.prepTime,
            prepTimeAsMinutes = recipeDetailsState.recipe.recipeDetails.prepTimeAsMinutes,
            cookingTimeAsString = recipeDetailsState.recipe.recipeDetails.cookingTime,
            cookingTimeAsMinutes = recipeDetailsState.recipe.recipeDetails.cookTimeAsMinutes,
        )
        Spacer(
            modifier = Modifier.height(PaddingLarge)
        )
        Text(
            text = stringResource(R.string.recipe_details_screen_ingredients),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .zIndex(4f)
                .fillMaxWidth()
                .semantics {
                    heading()
                }
        )
        Spacer(
            modifier = Modifier.height(PaddingMedium)
        )
        RecipeIngredientList(
            modifier = Modifier.zIndex(5f),
            ingredientList = recipeDetailsState.recipe.ingredients
        )
    }
}

@Preview(showBackground = true, name = "Recipe Details Screen - Success")
@Composable
fun PreviewRecipeDetailsScreenSuccess() {
    RecipeDetailsScreen(
        recipeDetailsStateValue = RecipeDetailsScreenState.Success(
            getDummyRecipe()
        ),
    )
}

@Preview(showBackground = true, name = "Recipe Details Screen - Loading")
@Composable
fun PreviewRecipeDetailsScreenLoading() {
    RecipeDetailsScreen(
        recipeDetailsStateValue = RecipeDetailsScreenState.Loading
    )
}

@Preview(showBackground = true, name = "Recipe Details Screen - Success")
@Composable
fun PreviewRecipeDetailsScreenError() {
    RecipeDetailsScreen(
        recipeDetailsStateValue = RecipeDetailsScreenState.Error
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