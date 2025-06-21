package com.app.data.repository.films

import com.app.domain.entities.Film
import retrofit2.http.GET

interface FilmsNetworkApi {

    @GET("films")
    suspend fun films() : List<Film>
}