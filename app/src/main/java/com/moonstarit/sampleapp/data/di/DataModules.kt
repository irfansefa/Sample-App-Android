package com.moonstarit.sampleapp.data.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.moonstarit.sampleapp.data.datasource.remote.AgeOfEmpiresApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModules: List<Module> by lazy {
    mutableListOf(apiModule, retrofitModule)
}

val apiModule = module {
    fun provideAoEApi(retrofit: Retrofit): AgeOfEmpiresApi {
        return retrofit.create(AgeOfEmpiresApi::class.java)
    }

    single { provideAoEApi(retrofit = get()) }
}

val retrofitModule = module {

    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    fun provideInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return logging
    }

    fun provideHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder().addInterceptor(interceptor)

        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://age-of-empires-2-api.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create(factory))
            .client(client)
            .build()
    }

    single { provideGson() }
    single { provideInterceptor() }
    single { provideHttpClient(interceptor = get()) }
    single { provideRetrofit(factory = get(), client = get()) }
}