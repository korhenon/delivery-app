package com.example.oech.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ServiceProvider {
    @Provides
    fun provideService(): ApiService {
        return Retrofit.Builder().baseUrl("https://prof-01o2.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }
}