package com.mr.misti.weather.config_di

import com.mr.misti.core.utils.CallService
import com.mr.misti.weather.data.source.remote.ds.ForecastDataSource
import com.mr.misti.weather.data.source.remote.ds.ForecastDataSourceImpl
import com.mr.misti.weather.data.source.remote.service.ForecastRestService
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
    fun provideApi(retrofit: Retrofit): ForecastRestService =
        retrofit.create(ForecastRestService::class.java)

    @Singleton
    @Provides
    fun provideLocationDataSource(
        @Named("Location") service: ForecastRestService,
        callService: CallService,
        @Named("API_KEY") apiKey: String
    ): ForecastDataSource {
        return ForecastDataSourceImpl(service, callService, apiKey)
    }
}
