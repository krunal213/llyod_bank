package com.app.data.datasource.films.network

import com.app.domain.entities.Film
import retrofit2.http.GET

interface FilmsService {

    @GET("films")
    suspend fun films() : List<Film>
}