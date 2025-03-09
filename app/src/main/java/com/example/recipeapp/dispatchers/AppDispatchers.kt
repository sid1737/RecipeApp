package com.example.recipeapp.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

interface AppDispatchers {
    val io: CoroutineDispatcher
}

class AppDispatchersImpl @Inject constructor(): AppDispatchers {
    override val io: CoroutineDispatcher = Dispatchers.IO
}