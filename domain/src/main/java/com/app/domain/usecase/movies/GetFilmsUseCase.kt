package com.app.domain.usecase.movies

import com.app.domain.entities.Film
import com.app.domain.repository_contract.FilmsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetFilmsUseCase @Inject constructor(private val filmsRepository: FilmsRepository) {

    suspend operator fun invoke(): List<Film> {
        return withContext(Dispatchers.Default) {
            filmsRepository.films()
        }
    }
}