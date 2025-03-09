package com.example.recipeapp.di

import com.example.recipeapp.data.repository.RecipeRepositoryImpl
import com.example.recipeapp.dispatchers.AppDispatchers
import com.example.recipeapp.dispatchers.AppDispatchersImpl
import com.example.recipeapp.domain.repository.RecipeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindRecipeRepository(recipeRepositoryImpl: RecipeRepositoryImpl): RecipeRepository

    @Binds
    @Singleton
    abstract fun provideAppDispatchers(appDispatchersImpl: AppDispatchersImpl): AppDispatchers
}