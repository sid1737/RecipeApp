package com.example.recipeapp.viewmodelTest

import app.cash.turbine.test
import com.example.recipeapp.MockCoroutineDispatchers
import com.example.recipeapp.domain.repository.RecipeRepository
import com.example.recipeapp.mockDataProducer.RecipeMockDataProvider
import com.example.recipeapp.ui.recipeListScreen.RecipeListScreenEvents
import com.example.recipeapp.ui.recipeListScreen.RecipeListScreenState
import com.example.recipeapp.ui.recipeListScreen.RecipeListViewModel
import com.example.recipeapp.ui.uiState.toRecipeUiState
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RecipeListViewModelTest {
    @Mock
    lateinit var recipeRepository: RecipeRepository

    private val testDispatcher = MockCoroutineDispatchers()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `when repository sends the valid data then ui state emits Loading and Success`() {
        runTest(testDispatcher.io) {
            // Given
            val expectedDomainRecipeList = RecipeMockDataProvider.getMockRecipeList()
            val expectedRecipeUiStateList = expectedDomainRecipeList.map {
                it.toRecipeUiState()
            }
            Mockito.`when`(recipeRepository.getRecipe()).thenReturn(
                flowOf(
                    expectedDomainRecipeList
                )
            )
            val viewModel = RecipeListViewModel(recipeRepository, testDispatcher)

            // Then
            viewModel.uiState.test {
                assertEquals(awaitItem(), RecipeListScreenState.Loading)
                awaitItem().let {
                    assertTrue(it is RecipeListScreenState.Success)
                    assertEquals(expectedRecipeUiStateList, it.recipes)
                }
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun `when repository sends invalid data then ui state emits Loading and Error`() {
        runTest(testDispatcher.io) {
            // Given
            Mockito.`when`(recipeRepository.getRecipe()).thenReturn(
                flow{
                    throw Exception()
                }
            )
            val viewModel = RecipeListViewModel(recipeRepository, testDispatcher)

            // Then
            viewModel.uiState.test {
                assertEquals(awaitItem(), RecipeListScreenState.Loading)
                assertEquals(awaitItem(), RecipeListScreenState.Error)
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun `when navigate to recipe detail screen is triggered, it emits the navigate to recipe details event with right recipe ui object`() {
        runTest(testDispatcher.io) {
            // Given
            val viewModel = RecipeListViewModel(recipeRepository, testDispatcher)
            val mockRecipeUiStateObject = RecipeMockDataProvider.getMockRecipeUiState()

            // When
            viewModel.navigateToRecipeDetailsScreen(mockRecipeUiStateObject)

            // Then
            viewModel.recipeListScreenEvents.test {
                awaitItem().let {
                    assertTrue(it is RecipeListScreenEvents.NavigateToRecipeDetailsScreen)
                    assertEquals(expected = mockRecipeUiStateObject, actual = it.recipe)
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