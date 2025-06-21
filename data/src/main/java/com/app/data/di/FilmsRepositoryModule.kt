package com.app.data.di

import com.app.data.repository.films.FilmsRepositoryImpl
import com.app.domain.repository_contract.FilmsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class FilmsRepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindMoviesRepository(llyodMoviesRepositoryImpl: FilmsRepositoryImpl): FilmsRepository

}