package com.app.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class Film (
  var id: String? = null,
  var title: String? = null,
  var movie_banner: String? = null,
  var description: String? = null,
  var director: String? = null,
  var release_date: String? = null,
  var running_time: String? = null,
  var url: String? = null
)
