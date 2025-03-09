package com.example.recipeapp.mapperTest

import com.example.recipeapp.data.mapper.toRecipeList
import com.example.recipeapp.mockDataProducer.RecipeMockDataProvider
import org.junit.Test
import kotlin.test.assertEquals

class RecipeMapperTest {

    @Test
    fun `map valid list of recipe entities to domain objects returns correct list`() {
        // Given
        val mockRecipeEntityList = RecipeMockDataProvider.getMockRecipeEntityList()
        val expectedRecipeList = RecipeMockDataProvider.getMockRecipeList()

        // When
        val actualRecipeList = mockRecipeEntityList.toRecipeList()

        // Then
       assertEquals(expected = expectedRecipeList, actual = actualRecipeList)
    }
}