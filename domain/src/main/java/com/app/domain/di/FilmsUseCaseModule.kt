package com.app.domain.di

import com.app.domain.usecase.movies.GetFilmsUseCase
import com.app.domain.usecase.movies.GetFilmsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FilmsUseCaseModule {

    @Binds
    abstract fun bindMoviesUseCase(getMoviesUseCaseImpl: GetFilmsUseCaseImpl): GetFilmsUseCase

}