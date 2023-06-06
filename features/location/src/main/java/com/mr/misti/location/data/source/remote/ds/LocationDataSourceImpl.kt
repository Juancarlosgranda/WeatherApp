package com.mr.misti.location.data.source.remote.ds

import com.mr.misti.core.Either
import com.mr.misti.core.Failure
import com.mr.misti.core.utils.CallService
import com.mr.misti.location.data.source.remote.service.LocationRestService
import com.mr.misti.weather_api.data.LocationResponse
import javax.inject.Inject

class LocationDataSourceImpl @Inject constructor(
    private val restService: LocationRestService,
    private val caller: CallService,
    private val apiKey: String
) : LocationDataSource {

    override suspend fun getLocations(query: String): Either<Failure, List<LocationResponse>> =
        caller.callService {
            restService.getLocations(apiKey, query)
        }
}