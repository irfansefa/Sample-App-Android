package com.moonstarit.sampleapp.data.datasource.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AgeOfEmpiresApi {

    @GET("api/v1/civilizations")
    suspend fun getCivilizations(): Response<CivilizationsDto>

    @GET("api/v1/civilization/{id}")
    suspend fun getCivilizationDetail(
        @Path("id") id: Long
    ): Response<CivilizationDto>
}