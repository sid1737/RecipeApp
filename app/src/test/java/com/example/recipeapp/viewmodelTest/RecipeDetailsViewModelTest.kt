package com.example.recipeapp.viewmodelTest

import app.cash.turbine.test
import com.example.recipeapp.MockCoroutineDispatchers
import com.example.recipeapp.mockDataProducer.RecipeMockDataProvider
import com.example.recipeapp.ui.recipeDetailsScreen.RecipeDetailsScreenState
import com.example.recipeapp.ui.recipeDetailsScreen.RecipeDetailsViewModel
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RecipeDetailsViewModelTest {
    private val testDispatcher = MockCoroutineDispatchers()

    private lateinit var recipeDetailsViewModel: RecipeDetailsViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `when recipe details are loaded it fires the Recipe Details Screen Success event with the selected recipe ui data object `() {
        runTest(testDispatcher.io) {
            // Given
            recipeDetailsViewModel = RecipeDetailsViewModel()
            val mockExpectedRecipeUiState = RecipeMockDataProvider.getMockRecipeUiState()

            // When
            recipeDetailsViewModel.loadRecipe(mockExpectedRecipeUiState)

            // Then
            recipeDetailsViewModel.recipeDetailsScreenState.test {
                awaitItem().let {
                    assertTrue(it is RecipeDetailsScreenState.Success)
                    assertEquals(expected = mockExpectedRecipeUiState, actual = it.recipe)
                }
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @After
    fun cleanUp() {
        Mockito.clearAllCaches()
    }
}