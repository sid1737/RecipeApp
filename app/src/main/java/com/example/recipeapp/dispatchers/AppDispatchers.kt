package com.example.recipeapp.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface AppDispatchers {
    val ui: CoroutineDispatcher
    val io: CoroutineDispatcher
}

class AppDispatchersImpl: AppDispatchers {
    override val ui: CoroutineDispatcher = Dispatchers.Main
    override val io: CoroutineDispatcher = Dispatchers.IO
}