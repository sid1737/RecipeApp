package com.example.recipeapp.di

import com.example.recipeapp.dispatchers.AppDispatchers
import com.example.recipeapp.dispatchers.AppDispatchersImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherModule {
    @Binds
    @Singleton
    abstract fun provideAppDispatchers(appDispatchersImpl: AppDispatchersImpl): AppDispatchers
}