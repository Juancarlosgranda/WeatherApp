package com.mr.misti.location.data.repository

import com.mr.misti.core.Either
import com.mr.misti.core.Failure
import com.mr.misti.location.data.source.remote.ds.LocationDataSource
import com.mr.misti.location.domain.repository.LocationRepository
import com.mr.misti.location_api.data.toDomainModel
import com.mr.misti.location_api.domain.Location
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationDataSource: LocationDataSource
) : LocationRepository {
    override suspend fun getLocation(query: String): Either<Failure, List<Location>> {
        return locationDataSource.getLocations(query).coMapSuccess {
            it.map { locationResponse ->
                locationResponse.toDomainModel()
            }
        }
    }
}