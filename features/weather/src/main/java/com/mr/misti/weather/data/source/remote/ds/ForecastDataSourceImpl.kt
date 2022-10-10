package com.mr.misti.weather.data.source.remote.ds

import com.mr.misti.core.Either
import com.mr.misti.core.Failure
import com.mr.misti.core.utils.CallService
import com.mr.misti.weather.data.source.remote.model.ForecastResponse
import com.mr.misti.weather.data.source.remote.service.ForecastRestService
import javax.inject.Inject

class ForecastDataSourceImpl @Inject constructor(
    private val restService: ForecastRestService,
    private val caller: CallService,
    private val apiKey: String
) : ForecastDataSource {

    override suspend fun getForecasts(
        location: String,
        days: String
    ): Either<Failure, ForecastResponse> = caller.callService {
        restService.getForecasts(apiKey, location, days)
    }


}