package com.moonstarit.sampleapp

import android.app.Application
import com.moonstarit.sampleapp.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SampleAppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@SampleAppApplication)
            // Load modules
            modules(appModules)
            // use properties from assets/koin.properties
            androidFileProperties()
        }
    }
}