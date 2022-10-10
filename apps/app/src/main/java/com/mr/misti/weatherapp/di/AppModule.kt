package com.mr.misti.weatherapp.di

import android.content.Context
import com.mr.misti.weatherapp.WeatherApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(app: WeatherApp): Context {
        return app.applicationContext
    }
}