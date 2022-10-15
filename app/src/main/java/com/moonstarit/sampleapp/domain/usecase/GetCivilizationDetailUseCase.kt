package com.moonstarit.sampleapp.domain.usecase

import com.moonstarit.sampleapp.domain.model.CivilizationData
import com.moonstarit.sampleapp.domain.repository.CivilizationRepository
import com.moonstarit.sampleapp.domain.util.Resource

interface GetCivilizationDetailUseCase {
    suspend operator fun invoke(id: Long): Resource<CivilizationData>
}

class GetCivilizationDetailUseCaseImpl(
    private val repository: CivilizationRepository
) : GetCivilizationDetailUseCase {
    override suspend fun invoke(id: Long): Resource<CivilizationData> =
        repository.getCivilization(id)
}