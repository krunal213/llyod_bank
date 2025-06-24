package com.app.domain.usecase.movies

import com.app.domain.entities.Film
import com.app.domain.repository_contract.FilmsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetFilmsUseCase @Inject constructor(
    private val filmsRepository: FilmsRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    suspend operator fun invoke(): List<Film> {
        return withContext(dispatcher) {
            filmsRepository.films()
        }
    }
}