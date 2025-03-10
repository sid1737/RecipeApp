package com.example.recipeapp.repositoryTest

import android.content.Context
import android.content.res.AssetManager
import app.cash.turbine.test
import com.example.recipeapp.MockCoroutineDispatchers
import com.example.recipeapp.data.model.RecipeEntityList
import com.example.recipeapp.data.repository.RecipeRepositoryImpl
import com.example.recipeapp.domain.repository.RecipeRepository
import com.example.recipeapp.mockDataProducer.RecipeMockDataProvider
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.io.ByteArrayInputStream
import java.io.InputStreamReader
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class RecipeRepositoryImplTest {

    private lateinit var recipeRepository: RecipeRepository

    private val testDispatcher = MockCoroutineDispatchers()

    @Mock
    lateinit var gson: Gson

    @Mock
    lateinit var assetManager: AssetManager

    @Mock
    lateinit var context: Context

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        recipeRepository = RecipeRepositoryImpl(
            context,
            testDispatcher,
            gson
        )
    }

    @Test
    fun `when a valid json in the given format is read it emits a list of Recipe Objects`() {
        runTest(testDispatcher.io) {
            // Given
            val givenMockEntityList = RecipeMockDataProvider.getMockRecipeEntityList()
            val expectedRecipeList = RecipeMockDataProvider.getMockRecipeList()
            Mockito.`when`(context.assets).thenReturn(assetManager)
            Mockito.`when`(context.assets.open("recipes.json")).thenReturn(ByteArrayInputStream(
                byteArrayOf()
            ))
            Mockito.`when`(
                gson.fromJson(
                    ArgumentMatchers.any(InputStreamReader::class.java),
                    ArgumentMatchers.eq(RecipeEntityList::class.java)
                )
            ).thenReturn(givenMockEntityList)

            // Then
            recipeRepository.getRecipe().test {
                advanceUntilIdle()
                assertEquals(expected = expectedRecipeList, actual = awaitItem())
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @After
    fun cleanUp() {
        Mockito.clearAllCaches()
    }
}