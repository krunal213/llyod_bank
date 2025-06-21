package com.app.data.di

import android.content.Context
import com.app.data.BuildConfig
import com.app.data.repository.films.FilmsNetworkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FilmsNetworkModule {

    @Provides
    @Singleton
    fun provideNetworkConnectionInterceptor(
        @ApplicationContext context: Context
    ) = NetworkConnectionInterceptor(context)

    @Provides
    @Singleton
    fun provideOkHttpClient(
        interceptor: NetworkConnectionInterceptor
    ) = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Provides
    @Singleton
    fun provideGsonConverterFactory() = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory, okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()

    @Provides
    @Singleton
    fun provideFilmsNetworkApi(retrofit: Retrofit) = retrofit.create(FilmsNetworkApi::class.java)
}