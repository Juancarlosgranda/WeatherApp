package com.mr.misti.weather_api

import com.mr.misti.core.Either
import com.mr.misti.core.Failure
import com.mr.misti.weather_api.domain.Forecast

interface WeatherApi {

    suspend fun getForecasts(location: String, days: String): Either<Failure, Forecast>

}
