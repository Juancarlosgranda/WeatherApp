package com.mr.misti.location.domain.usecase

import com.mr.misti.core.Either
import com.mr.misti.core.Failure
import com.mr.misti.location_api.domain.Location
import com.mr.misti.location.domain.repository.LocationRepository
import javax.inject.Inject

class GetLocations @Inject constructor (
    private val repository: LocationRepository
) {

    suspend operator fun invoke(query: String): Either<Failure, List<Location>> {
        return repository.getLocation(query)
    }

}