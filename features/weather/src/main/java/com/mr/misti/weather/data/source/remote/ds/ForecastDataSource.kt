package com.mr.misti.weather.data.source.remote.ds

import com.mr.misti.core.Either
import com.mr.misti.core.Failure
import com.mr.misti.weather.data.source.remote.model.ForecastResponse

interface ForecastDataSource {

    suspend fun getForecasts(location: String, days: String): Either<Failure, ForecastResponse>

}