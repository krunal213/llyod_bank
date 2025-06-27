package com.app.data.di

import com.app.common.Constants.URL
import com.app.data.datasource.films.network.FilmsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FilmsNetworkModule {

    @Provides
    @Singleton
    fun provideGsonConverterFactory() = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory) =
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(gsonConverterFactory)
            .build()

    @Provides
    @Singleton
    fun provideFilmsService(retrofit: Retrofit) = retrofit.create(FilmsService::class.java)
}