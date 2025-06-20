package com.app.presentation

import kotlinx.serialization.Serializable

@Serializable
object FilmsScreen

@Serializable
data class FilmDetailsScreen(
    var id: String? = null,
    var title: String? = null,
    var movieBanner: String? = null,
    var description: String? = null,
    var director: String? = null,
    var releaseDate: String? = null,
    var url: String? = null,
    var runningTime: String? = null
)


