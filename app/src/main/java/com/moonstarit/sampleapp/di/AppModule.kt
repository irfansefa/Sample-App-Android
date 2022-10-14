package com.moonstarit.sampleapp.di

import com.moonstarit.sampleapp.data.di.dataModules
import com.moonstarit.sampleapp.domain.domainModules
import com.moonstarit.sampleapp.ui.di.presentationModules
import org.koin.core.module.Module

val appModules: List<Module> by lazy {
    listOf<Module>()
        .plus(presentationModules)
        .plus(domainModules)
        .plus(dataModules)
}