package com.app.domain.usecase.movies

import com.app.domain.entities.FilmInfo

interface GetFilmsUseCase {

    suspend operator fun invoke(): List<FilmInfo>

}