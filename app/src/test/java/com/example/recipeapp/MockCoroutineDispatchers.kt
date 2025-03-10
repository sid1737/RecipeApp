package com.example.recipeapp

import com.example.recipeapp.dispatchers.AppDispatchers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.StandardTestDispatcher

class MockCoroutineDispatchers: AppDispatchers {
    override val io: CoroutineDispatcher = StandardTestDispatcher()
}