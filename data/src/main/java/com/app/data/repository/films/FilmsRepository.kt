package com.app.data.repository.films

import com.app.data.entities.Film

interface FilmsRepository {
    suspend fun films() : List<Film>
}