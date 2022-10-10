package com.mr.misti.location.config_di

import com.mr.misti.core.utils.CallService
import com.mr.misti.location.data.source.remote.ds.LocationDataSource
import com.mr.misti.location.data.source.remote.ds.LocationDataSourceImpl
import com.mr.misti.location.data.source.remote.service.LocationRestService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    @Named("Location")
    fun provideApi(retrofit: Retrofit): LocationRestService =
        retrofit.create(LocationRestService::class.java)

    @Singleton
    @Provides
    fun provideLocationDataSource(
        @Named("Location") service: LocationRestService,
        callService: CallService,
        @Named("API_KEY") apiKey: String
    ): LocationDataSource {
        return LocationDataSourceImpl(service, callService, apiKey)
    }
}
