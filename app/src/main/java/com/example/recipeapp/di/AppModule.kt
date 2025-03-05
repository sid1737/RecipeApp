package com.example.recipeapp.di

import android.content.Context
import com.example.recipeapp.dispatchers.AppDispatchers
import com.example.recipeapp.dispatchers.AppDispatchersImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideAppDispatchers(): AppDispatchers = AppDispatchersImpl()

    @Provides
    @Singleton
    fun providesGson(): Gson = GsonBuilder().create()
}