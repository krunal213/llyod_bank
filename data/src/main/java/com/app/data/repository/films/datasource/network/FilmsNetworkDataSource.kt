package com.app.data.repository.films.datasource.network

import com.app.data.entities.Film

interface FilmsNetworkDataSource {
    suspend fun films() : List<Film>
}