package com.moonstarit.sampleapp.data.repository

import com.moonstarit.sampleapp.data.datasource.remote.AgeOfEmpiresApi
import com.moonstarit.sampleapp.data.mapper.toCivilizationData
import com.moonstarit.sampleapp.domain.model.CivilizationData
import com.moonstarit.sampleapp.domain.repository.CivilizationRepository
import com.moonstarit.sampleapp.domain.util.Resource

class CivilizationRepositoryImpl(
    private val aeoApi: AgeOfEmpiresApi
) : CivilizationRepository {
    override suspend fun getCivilizations(): Resource<List<CivilizationData>> {
        return try {
            var civilizations: List<CivilizationData> = emptyList()
            val response = aeoApi.getCivilizations()
            if (response.isSuccessful) {
                civilizations = response.body()?.civilizations?.map {
                    it.toCivilizationData()
                }.orEmpty()
            }
            Resource.Success(civilizations)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}