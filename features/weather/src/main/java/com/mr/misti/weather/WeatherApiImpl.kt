package com.mr.misti.weather

import com.mr.misti.core.Either
import com.mr.misti.core.Failure
import com.mr.misti.weather.domain.usecase.GetForecasts
import com.mr.misti.weather_api.WeatherApi
import com.mr.misti.weather_api.domain.Forecast
import dagger.hilt.internal.ComponentEntryPoint
import javax.inject.Inject

class WeatherApiImpl @Inject constructor(
    private val getForecasts: GetForecasts
) : WeatherApi {

    override suspend fun getForecasts(location: String, days: String): Either<Failure, Forecast> {
        return getForecasts.invoke(location, days)
    }

}
