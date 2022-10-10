package com.mr.misti.location.data.source.remote.ds

import com.mr.misti.core.Either
import com.mr.misti.core.Failure
import com.mr.misti.location_api.data.LocationResponse

interface LocationDataSource {

    suspend fun getLocations(query: String): Either<Failure, List<LocationResponse>>
}