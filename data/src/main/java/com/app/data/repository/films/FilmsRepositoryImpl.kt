package com.app.data.repository.films

import com.app.data.datasource.films.network.FilmsNetworkDataSource
import com.app.domain.entities.Film
import com.app.domain.repository.films.FilmsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FilmsRepositoryImpl @Inject constructor(
    private val filmsNetworkDataSource: FilmsNetworkDataSource,
) : FilmsRepository {

    override suspend fun films(): List<Film> {
        return filmsNetworkDataSource.films()
    }

}