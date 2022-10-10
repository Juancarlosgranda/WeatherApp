package com.mr.misti.weather.design.di

import android.content.Context
import com.mr.misti.core.utils.ConnectionUtils
import com.mr.misti.core.utils.SupportInterceptor
import com.mr.misti.weather.design.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideConnectionUtils(@ApplicationContext appContext: Context): ConnectionUtils {
        return ConnectionUtilsImpl(appContext)
    }

    @Provides
    @Singleton
    fun provideInterceptor(): Interceptor {
        return SupportInterceptor()
    }

    @Provides
    @Singleton
    fun provideFactoryConverterWithGson(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: Interceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(interceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(authInterceptor)
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterGson: Converter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BaseURL)
            .addConverterFactory(converterGson)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    @Named("API_KEY")
    fun provideApiKey(): String {
        return "de5553176da64306b86153651221606"
    }

    /*@Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): RestService = retrofit.create(RestService::class.java)*/
}