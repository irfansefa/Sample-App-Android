package com.moonstarit.sampleapp.domain.repository

import com.moonstarit.sampleapp.domain.model.CivilizationData
import com.moonstarit.sampleapp.domain.util.Resource

interface CivilizationRepository {
    suspend fun getCivilizations(): Resource<List<CivilizationData>>

    suspend fun getCivilization(id: Long): Resource<CivilizationData>
}