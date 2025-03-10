package com.example.recipeapp.ui.recipeListScreen

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.recipeapp.R
import com.example.recipeapp.ui.commonComponents.ErrorScreen
import com.example.recipeapp.ui.commonComponents.LoadingIndicator
import com.example.recipeapp.ui.navigation.ScreenNames
import com.example.recipeapp.ui.recipeListScreen.components.RecipeList
import com.example.recipeapp.ui.uiState.RecipeUiState
import kotlinx.coroutines.flow.collectLatest

@Composable
fun RecipeListScreen(
    navHostController: NavHostController,
    recipeListViewModel: RecipeListViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val recipeListScreenStateValue = recipeListViewModel.recipeListUiState.collectAsStateWithLifecycle().value

    LaunchedEffect(Unit) {
        recipeListViewModel.recipeListScreenEvents.collectLatest { event ->
            if (event is RecipeListScreenEvents.NavigateToRecipeDetailsScreen) {
                navHostController.navigate(ScreenNames.RecipeDetailScreen(event.recipe))
            }
        }
    }

    GetRecipeListScreenComponents(
        modifier,
        recipeListScreenStateValue,
        {
            recipeListViewModel.retryFetchingDataFromFile()
        },
        onRecipeClick =  { recipe: RecipeUiState ->
            recipeListViewModel.navigateToRecipeDetailsScreen(recipe)
        }
    )
}

@Composable
private fun GetRecipeListScreenComponents(
    modifier: Modifier = Modifier,
    recipeListScreenStateValue: RecipeListScreenState,
    onRetry: () -> Unit,
    onRecipeClick: (RecipeUiState) -> Unit
) {
    val localConfiguration = LocalConfiguration.current

    val isPortrait = localConfiguration.orientation == Configuration.ORIENTATION_PORTRAIT

    val numberOfColumns = if (isPortrait) 2 else 3

    when (recipeListScreenStateValue) {
        is RecipeListScreenState.Success -> {
            RecipeList(
                numberOfColumns = numberOfColumns,
                modifier = modifier,
                recipes = recipeListScreenStateValue.recipes,
                onRecipeCLick = onRecipeClick
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
                errorMessage = stringResource(R.string.error_message_recipe_list_screen),
                retryButtonClick = {
                    onRetry()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeListScreenWithAllThreeStates(
    @PreviewParameter(RecipeListScreenPreviewParameter::class)
    recipeListScreenStateValue: RecipeListScreenState
) {
    GetRecipeListScreenComponents(
        recipeListScreenStateValue = recipeListScreenStateValue,
        onRetry = {},
        onRecipeClick = {}
    )
}