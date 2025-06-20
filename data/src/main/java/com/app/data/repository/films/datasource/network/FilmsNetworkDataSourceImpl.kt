package com.app.data.repository.films.datasource.network

import com.app.data.entities.Film
import javax.inject.Inject

class FilmsNetworkDataSourceImpl @Inject constructor(private val filmsService: FilmsService) :
    FilmsNetworkDataSource {
    override suspend fun films(): List<Film> {
        return filmsService.films()
    }


}