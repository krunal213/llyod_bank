package com.app.domain.repository_contract

import com.app.domain.entities.Film

interface FilmsRepository {
    suspend fun films() : List<Film>
}