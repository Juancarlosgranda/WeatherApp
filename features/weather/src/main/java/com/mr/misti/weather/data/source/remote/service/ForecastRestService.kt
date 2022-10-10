package com.mr.misti.weather.data.source.remote.service

import com.mr.misti.weather.data.source.remote.model.ForecastResponse
import retrofit2.Response
import retrofit2.http.*

interface ForecastRestService {
    @GET("v1/forecast.json")
    suspend fun getForecasts(
        @Query("key") key: String,
        @Query("q") query: String,
        @Query("days") day: String
    ): Response<ForecastResponse>
}