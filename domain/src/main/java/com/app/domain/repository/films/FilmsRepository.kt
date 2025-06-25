package com.app.domain.repository.films

import com.app.domain.entities.Film

interface FilmsRepository {
    suspend fun films() : List<Film>
}