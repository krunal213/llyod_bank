package com.app.domain.di

import com.app.domain.usecase.movies.GetFilmsUseCase
import com.app.domain.usecase.movies.GetFilmsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class FilmsUseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindMoviesUseCase(getMoviesUseCaseImpl: GetFilmsUseCaseImpl): GetFilmsUseCase

}