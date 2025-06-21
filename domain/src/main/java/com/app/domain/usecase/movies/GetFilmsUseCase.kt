package com.app.domain.usecase.movies

import com.app.domain.entities.Film

interface GetFilmsUseCase {

    suspend operator fun invoke(): List<Film>

}