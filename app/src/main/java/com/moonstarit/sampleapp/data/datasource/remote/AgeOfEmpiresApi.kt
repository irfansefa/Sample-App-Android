package com.moonstarit.sampleapp.data.datasource.remote

import retrofit2.Response
import retrofit2.http.GET

interface AgeOfEmpiresApi {

    @GET("api/v1/civilizations")
    suspend fun getCivilizations(): Response<CivilizationsDto>
}