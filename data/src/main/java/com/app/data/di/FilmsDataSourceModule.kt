package com.app.data.di

import com.app.data.repository.films.datasource.network.FilmsNetworkDataSource
import com.app.data.repository.films.datasource.network.FilmsNetworkDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class FilmsDataSourceModule {

    @Binds
    @ViewModelScoped
    abstract fun bindMoviesNetworkDataSource(moviesNetworkDataSourceImpl: FilmsNetworkDataSourceImpl): FilmsNetworkDataSource

}