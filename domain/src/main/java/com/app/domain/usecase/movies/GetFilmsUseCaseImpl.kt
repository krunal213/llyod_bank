package com.app.domain.usecase.movies

import com.app.data.repository.films.FilmsRepository
import com.app.domain.entities.FilmInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetFilmsUseCaseImpl @Inject constructor(private val filmsRepository: FilmsRepository) :
    GetFilmsUseCase {

    override suspend fun invoke(): List<FilmInfo> {
        return withContext(Dispatchers.Default) {
            filmsRepository.films().map {
                FilmInfo(
                    id = it.id,
                    title = it.title,
                    movieBanner = it.movie_banner,
                    description = it.description,
                    director = it.director,
                    releaseDate = it.release_date,
                    url = it.url,
                    runningTime = it.running_time
                )
            }
        }
    }
}