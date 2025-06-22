package com.app.data.datasource.films.network

import com.app.domain.entities.Film
import javax.inject.Inject

class FilmsNetworkDataSourceImpl @Inject constructor(private val filmsService: FilmsService) :
    FilmsNetworkDataSource {
    override suspend fun films(): List<Film> {
        return filmsService.films()
    }


}