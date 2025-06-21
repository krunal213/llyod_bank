package com.app.data.repository.films

import com.app.domain.entities.Film
import com.app.domain.repository_contract.FilmsRepository
import javax.inject.Inject

class FilmsRepositoryImpl @Inject constructor(private val filmsNetworkApi: FilmsNetworkApi) :
    FilmsRepository {
    override suspend fun films(): List<Film> {
        return filmsNetworkApi.films()
    }

}