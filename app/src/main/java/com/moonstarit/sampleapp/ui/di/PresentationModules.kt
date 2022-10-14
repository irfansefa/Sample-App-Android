package com.moonstarit.sampleapp.ui.di

import com.moonstarit.sampleapp.ui.civilizations.CivilizationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


val presentationModules: List<Module> by lazy {
    mutableListOf(viewModelModule)
}

val viewModelModule = module {
    viewModel {
        CivilizationsViewModel(get())
    }
}