package com.app.data.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.gson.GsonConverterFactory
import com.app.data.repository.films.FilmsNetworkApi

@Module
@InstallIn(SingletonComponent::class)
object FilmsNetworkModule {

    private val URL = "https://ghibliapi.vercel.app/"

    @Provides
    fun provideGsonConverterFactory() = GsonConverterFactory.create()

    @Provides
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory) =
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(gsonConverterFactory)
            .build()

    @Provides
    fun provideFilmsNetworkApi(retrofit: Retrofit) = retrofit.create(FilmsNetworkApi::class.java)
}