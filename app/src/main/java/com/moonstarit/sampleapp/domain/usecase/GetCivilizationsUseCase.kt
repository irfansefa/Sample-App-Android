package com.moonstarit.sampleapp.domain.usecase

import com.moonstarit.sampleapp.domain.model.CivilizationData
import com.moonstarit.sampleapp.domain.repository.CivilizationRepository
import com.moonstarit.sampleapp.domain.util.Resource

interface GetCivilizationsUseCase {
    suspend operator fun invoke(): Resource<List<CivilizationData>>
}

class GetCivilizationsUseCaseImpl(
    private val repository: CivilizationRepository
) : GetCivilizationsUseCase {
    override suspend fun invoke(): Resource<List<CivilizationData>> = repository.getCivilizations()
}