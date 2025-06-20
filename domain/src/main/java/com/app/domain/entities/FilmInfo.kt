package com.app.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class FilmInfo(
    var id: String? = null,
    var title: String? = null,
    var movieBanner: String? = null,
    var description: String? = null,
    var director: String? = null,
    var releaseDate: String? = null,
    var url: String? = null,
    var runningTime: String? = null,
)