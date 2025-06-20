package com.app.data.repository.films.datasource.network

import com.app.data.entities.Film
import retrofit2.http.GET

interface FilmsService {

    @GET("films")
    suspend fun films() : List<Film>
}