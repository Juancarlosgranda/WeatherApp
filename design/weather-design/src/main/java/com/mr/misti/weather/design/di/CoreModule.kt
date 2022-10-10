package com.mr.misti.weather.design.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideCoroutineContextProvider(): CoroutineContextProvider =
        object : CoroutineContextProvider {
            override val io: CoroutineContext
                get() = Dispatchers.IO
            override val main: CoroutineContext
                get() = Dispatchers.Main
            override val default: CoroutineContext
                get() = Dispatchers.Default
        }
}
