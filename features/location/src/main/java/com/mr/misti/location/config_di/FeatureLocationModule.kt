package com.mr.misti.location.config_di

import com.mr.misti.location.data.repository.LocationRepositoryImpl
import com.mr.misti.location.domain.repository.LocationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FeatureLocationModule {

    @Binds
    abstract fun provideArticleRepository(
        locationRepository: LocationRepositoryImpl
    ): LocationRepository
}