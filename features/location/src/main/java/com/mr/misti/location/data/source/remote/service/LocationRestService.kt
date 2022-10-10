package com.mr.misti.location.data.source.remote.service

import com.mr.misti.location_api.data.LocationResponse
import retrofit2.Response
import retrofit2.http.*

interface LocationRestService {
    @GET("v1/search.json")
    suspend fun getLocations(
        @Query("key") key: String,
        @Query("q") query: String
    ): Response<List<LocationResponse>>
}