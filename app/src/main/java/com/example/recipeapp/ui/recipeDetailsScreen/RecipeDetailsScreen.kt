package com.example.recipeapp.ui.recipeDetailsScreen

import RecipeDetailScreenSubText
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.SubcomposeAsyncImage
import com.example.recipeapp.R
import com.example.recipeapp.ui.commonComponents.LoadingIndicator
import com.example.recipeapp.ui.commonComponents.ErrorScreen
import com.example.recipeapp.ui.recipeDetailsScreen.components.RecipeDetailScreenTitle
import com.example.recipeapp.ui.recipeDetailsScreen.components.RecipeIngredientList
import com.example.recipeapp.ui.recipeDetailsScreen.components.RecipePrepDetailsComponent
import com.example.recipeapp.ui.theme.Dimens.SpaceExtraLarge
import com.example.recipeapp.ui.theme.Dimens.SpaceLarge
import com.example.recipeapp.ui.theme.Dimens.SpaceMedium
import com.example.recipeapp.ui.theme.Dimens.SpaceSmall
import com.example.recipeapp.ui.uiState.RecipeUiState

@Composable
fun RecipeDetailScreen(
    modifier: Modifier = Modifier,
    recipeDetailScreenViewModel: RecipeDetailsViewModel = hiltViewModel(),
    recipe: RecipeUiState
) {
    val localConfiguration = LocalConfiguration.current

    val isPortrait = localConfiguration.orientation == Configuration.ORIENTATION_PORTRAIT

    LaunchedEffect(recipe) {
        recipeDetailScreenViewModel.loadRecipe(recipe)
    }

    val recipeDetailsStateValue =
        recipeDetailScreenViewModel.recipeDetailsScreenState.collectAsStateWithLifecycle().value

    if (isPortrait) {
        RecipeDetailsScreenPortraitMode(
            modifier,
            recipeDetailsStateValue
        )
    } else {
        RecipeDetailsScreenLandScapeMode(
            modifier,
            recipeDetailsStateValue
        )
    }
}

@Composable
private fun RecipeDetailsScreenPortraitMode(
    modifier: Modifier = Modifier,
    recipeDetailsStateValue: RecipeDetailsScreenState
) {
    when (recipeDetailsStateValue) {
        is RecipeDetailsScreenState.Success -> {
            GetRecipeDetailScreenPortraitModeComponents(
                modifier,
                recipeDetailsStateValue.recipe
            )
        }

        RecipeDetailsScreenState.Error -> {
            ErrorScreen(
                modifier = modifier,
                errorMessage = stringResource(R.string.error_message_recipe_details_screen)
            )
        }

        RecipeDetailsScreenState.Loading -> {
            LoadingIndicator(
                modifier = modifier
            )
        }
    }
}

@Composable
private fun GetRecipeDetailScreenPortraitModeComponents(
    modifier: Modifier = Modifier,
    recipeUiState: RecipeUiState
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(SpaceMedium)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        RecipeDetailScreenTitle(
            recipeScreenTitle = recipeUiState.recipeName
        )
        Spacer(
            modifier = Modifier.height(SpaceLarge)
        )
        RecipeDetailScreenSubText(
            recipeSubText = recipeUiState.recipeDescription
        )
        Spacer(
            modifier = Modifier.height(SpaceLarge)
        )
        SubcomposeAsyncImage(
            modifier = Modifier
                .fillMaxSize(),
            model = recipeUiState.recipeImageUrl,
            contentDescription = null,
            loading = {
                CircularProgressIndicator()
            },
            contentScale = ContentScale.Crop
        )
        Spacer(
            modifier = Modifier.height(SpaceLarge)
        )
        RecipePrepDetailsComponent(
            totalServes = recipeUiState.totalServes,
            prepTimeAsString = recipeUiState.totalPrepTimeAsString,
            prepTimeInHoursAndMinutes = recipeUiState.totalPreparationTimeInHoursAndMinutes,
            cookingTimeAsString = recipeUiState.totalCookingTimeAsString,
            cookingTimeInHoursAndMinutes = recipeUiState.totalCookingTimeInHoursAndMinutes,
        )
        Spacer(
            modifier = Modifier.height(SpaceExtraLarge)
        )
        Text(
            text = stringResource(R.string.recipe_details_screen_ingredients),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .semantics {
                    heading()
                }
        )
        Spacer(
            modifier = Modifier.height(SpaceMedium)
        )
        RecipeIngredientList(
            ingredientList = recipeUiState.ingredients
        )
    }
}

@Composable
fun RecipeDetailsScreenLandScapeMode(
    modifier: Modifier = Modifier,
    recipeDetailsStateValue: RecipeDetailsScreenState
) {
    when (recipeDetailsStateValue) {
        is RecipeDetailsScreenState.Success -> {
            GetRecipeDetailScreenLandscapeModeComponents(
                modifier = modifier,
                recipeDetailsStateValue.recipe
            )
        }
        RecipeDetailsScreenState.Error -> {
            ErrorScreen(
                modifier = modifier,
                errorMessage = stringResource(R.string.error_message_recipe_details_screen)
            )
        }

        RecipeDetailsScreenState.Loading -> {
            LoadingIndicator(
                modifier = modifier
            )
        }
    }
}

@Composable
private fun GetRecipeDetailScreenLandscapeModeComponents(
    modifier: Modifier = Modifier,
    recipe: RecipeUiState,
) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(SpaceMedium),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SubcomposeAsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            model = recipe.recipeImageUrl,
            contentDescription = null,
            loading = {
                CircularProgressIndicator()
            }
        )
        Spacer(
            modifier = Modifier.width(SpaceSmall)
        )
        VerticalDivider(
            modifier = Modifier.width(1.dp)
        )
        Spacer(
            modifier = Modifier.width(SpaceSmall)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceMedium)
                .verticalScroll(rememberScrollState())
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            RecipeDetailScreenTitle(
                recipeScreenTitle = recipe.recipeName
            )
            Spacer(
                modifier = Modifier.height(SpaceLarge)
            )
            RecipeDetailScreenSubText(
                recipeSubText = recipe.recipeDescription
            )
            Spacer(
                modifier = Modifier.height(SpaceLarge)
            )
            RecipePrepDetailsComponent(
                totalServes = recipe.totalServes,
                prepTimeAsString = recipe.totalPrepTimeAsString,
                prepTimeInHoursAndMinutes = recipe.totalPreparationTimeInHoursAndMinutes,
                cookingTimeAsString = recipe.totalCookingTimeAsString,
                cookingTimeInHoursAndMinutes = recipe.totalCookingTimeInHoursAndMinutes,
            )
            Spacer(
                modifier = Modifier.height(SpaceMedium)
            )
            Text(
                text = stringResource(R.string.recipe_details_screen_ingredients),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .semantics {
                        heading()
                    }
            )
            Spacer(
                modifier = Modifier.height(SpaceMedium)
            )
            RecipeIngredientList(
                ingredientList = recipe.ingredients
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeDetailsScreenPortraitModeWithAllThreeStates(
    @PreviewParameter(RecipeDetailsScreenPreviewParameter::class)
    recipeDetailsStateValue: RecipeDetailsScreenState
) {
    RecipeDetailsScreenPortraitMode(
        recipeDetailsStateValue = recipeDetailsStateValue
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewRecipeDetailsScreenLandscapeModeWithAllThreeUiStates(
    @PreviewParameter(RecipeDetailsScreenPreviewParameter::class)
    recipeDetailsStateValue: RecipeDetailsScreenState
) {
    RecipeDetailsScreenLandScapeMode(
        recipeDetailsStateValue = recipeDetailsStateValue
    )
}