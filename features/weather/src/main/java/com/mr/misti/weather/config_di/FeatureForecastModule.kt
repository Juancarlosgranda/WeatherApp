package com.mr.misti.weather.config_di

import com.mr.misti.weather.data.repository.ForecastRepositoryImpl
import com.mr.misti.weather.domain.repository.ForecastRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FeatureForecastModule {

    @Binds
    abstract fun provideForecastRepository(
        forecastRepository: ForecastRepositoryImpl
    ): ForecastRepository
}