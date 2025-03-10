package com.example.recipeapp

import com.example.recipeapp.dispatchers.AppDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.StandardTestDispatcher

class MockCoroutineDispatchers: AppDispatchers {
    private val standardTestDispatcher = StandardTestDispatcher()
    override val io: CoroutineDispatcher = standardTestDispatcher
}