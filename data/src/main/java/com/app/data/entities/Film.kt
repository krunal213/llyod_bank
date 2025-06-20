package com.app.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class Film (
  var id: String? = null,
  var title: String? = null,
  var original_title: String? = null,
  var original_title_romanised: String? = null,
  var image: String? = null,
  var movie_banner: String? = null,
  var description: String? = null,
  var director: String? = null,
  var producer: String? = null,
  var release_date: String? = null,
  var running_time: String? = null,
  var rt_score: String? = null,
  var people: List<String>? = null,
  var species: List<String>? = null,
  var locations: List<String>? = null,
  var vehicles: List<String>? = null,
  var url: String? = null
)