package com.example.recipeapp.ui.recipeListScreen

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.recipeapp.R
import com.example.recipeapp.domain.models.Ingredient
import com.example.recipeapp.domain.models.Recipe
import com.example.recipeapp.domain.models.RecipeDetails
import com.example.recipeapp.ui.recipeListScreen.components.ErrorScreen
import com.example.recipeapp.ui.recipeListScreen.components.LoadingIndicator
import com.example.recipeapp.ui.recipeListScreen.components.RecipeList

@Composable
fun RecipeListScreen(
    recipeListViewModel: RecipeListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val recipeListScreenStateValue = recipeListViewModel.uiState.collectAsStateWithLifecycle().value
    GetRecipeListScreenComponents(modifier,recipeListScreenStateValue) {
        recipeListViewModel.retryFetchingDataFromFile()
    }
}

@Composable
private fun GetRecipeListScreenComponents(
    modifier: Modifier = Modifier,
    recipeListScreenStateValue: RecipeListScreenState,
    onRetry: () -> Unit
) {
    val localConfiguration = LocalConfiguration.current

    val isPortrait = localConfiguration.orientation == Configuration.ORIENTATION_PORTRAIT

    val numberOfColumns = if (isPortrait) 2 else 3

    when (recipeListScreenStateValue) {
        is RecipeListScreenState.Success -> {
            RecipeList(
                numberOfColumns = numberOfColumns,
                modifier = modifier,
                recipes = recipeListScreenStateValue.recipes
            )
        }

        is RecipeListScreenState.Loading -> {
            LoadingIndicator(
                modifier = modifier
            )
        }

        is RecipeListScreenState.Error -> {
            ErrorScreen(
                modifier = modifier,
                errorMessage = stringResource(R.string.error_message),
                errorButtonText = stringResource(R.string.retry_button_text),
                retryButtonClick = {
                    onRetry()
                }
            )
        }
    }
}

@Preview(showBackground = true, name = "RecipeListScreen - Success")
@Composable
fun PreviewRecipeListScreenSuccess() {
    GetRecipeListScreenComponents(
        recipeListScreenStateValue = RecipeListScreenState.Success(
            listOf(getDummyRecipe())
        )
    ) { }
}

@Preview(showBackground = true, name = "RecipeListScreen - Loading")
@Composable
fun PreviewRecipeListScreenLoading() {
    GetRecipeListScreenComponents(
        recipeListScreenStateValue = RecipeListScreenState.Loading
    ) { }
}

@Preview(showBackground = true, name = "RecipeListScreen - Error")
@Composable
fun PreviewRecipeListScreen() {
    GetRecipeListScreenComponents(
        recipeListScreenStateValue = RecipeListScreenState.Error
    ) { }
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