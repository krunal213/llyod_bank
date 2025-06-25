package com.app.data.di

import com.app.data.repository.films.FilmsRepositoryImpl
import com.app.domain.repository.films.FilmsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FilmsRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMoviesRepository(filmsRepositoryImpl: FilmsRepositoryImpl): FilmsRepository

}