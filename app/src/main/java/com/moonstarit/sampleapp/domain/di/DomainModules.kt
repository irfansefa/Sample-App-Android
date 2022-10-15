package com.moonstarit.sampleapp.domain.di

import com.moonstarit.sampleapp.data.repository.CivilizationRepositoryImpl
import com.moonstarit.sampleapp.domain.repository.CivilizationRepository
import com.moonstarit.sampleapp.domain.usecase.GetCivilizationDetailUseCase
import com.moonstarit.sampleapp.domain.usecase.GetCivilizationDetailUseCaseImpl
import com.moonstarit.sampleapp.domain.usecase.GetCivilizationsUseCase
import com.moonstarit.sampleapp.domain.usecase.GetCivilizationsUseCaseImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val domainModules: List<Module> by lazy {
    mutableListOf(useCaseModule, repositoryModule)
}

val useCaseModule = module {
    single<GetCivilizationsUseCase> {
        GetCivilizationsUseCaseImpl(get())
    }
    single<GetCivilizationDetailUseCase> {
        GetCivilizationDetailUseCaseImpl(get())
    }
}

val repositoryModule = module {
    single<CivilizationRepository> {
        CivilizationRepositoryImpl(get())
    }
}