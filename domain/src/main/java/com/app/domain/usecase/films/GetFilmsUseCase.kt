package com.app.domain.usecase.films

import com.app.domain.entities.Film
import com.app.domain.repository.films.FilmsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetFilmsUseCase @Inject constructor(
    private val filmsRepository: FilmsRepository
) {

    suspend operator fun invoke(): List<Film> = filmsRepository.films()
}