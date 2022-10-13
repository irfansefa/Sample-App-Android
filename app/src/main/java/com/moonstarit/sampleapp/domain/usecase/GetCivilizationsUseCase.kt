package com.moonstarit.sampleapp.domain.usecase

import com.moonstarit.sampleapp.data.datasource.remote.RetrofitInstance
import com.moonstarit.sampleapp.data.repository.CivilizationRepositoryImpl
import com.moonstarit.sampleapp.domain.model.CivilizationData
import com.moonstarit.sampleapp.domain.repository.CivilizationRepository
import com.moonstarit.sampleapp.domain.util.Resource

interface GetCivilizationsUseCase {
    suspend operator fun invoke(): Resource<List<CivilizationData>>
}

class GetCivilizationsUseCaseImpl(
    private val repository: CivilizationRepository = CivilizationRepositoryImpl(RetrofitInstance.api)
) : GetCivilizationsUseCase {
    override suspend fun invoke(): Resource<List<CivilizationData>> = repository.getCivilizations()
}