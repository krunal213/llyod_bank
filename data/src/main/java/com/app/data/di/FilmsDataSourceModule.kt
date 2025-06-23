package com.app.data.di

import com.app.data.datasource.films.network.FilmsNetworkDataSource
import com.app.data.datasource.films.network.FilmsNetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FilmsDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindFilmsNetworkDataSourceImpl(filmsNetworkDataSourceImpl: FilmsNetworkDataSourceImpl): FilmsNetworkDataSource

}