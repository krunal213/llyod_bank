package com.app.data.datasource.films.network

import com.app.domain.entities.Film

interface FilmsNetworkDataSource {
    suspend fun films() : List<Film>
}