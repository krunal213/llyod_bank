package com.app.domain.usecase.movies

import com.app.MockData
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetFilmsUseCaseImplTest {

    private lateinit var getFilmsUseCase: GetFilmsUseCase
    private lateinit var filmsRepository: FilmsRepository

    @Before
    fun setUp() {
        filmsRepository = mockk<FilmsRepository>()
        getFilmsUseCase = GetFilmsUseCaseImpl(filmsRepository)
    }

    @Test
    fun convert_film_type_to_film_info_type() = runTest {
        val film = MockData.film

        val expectedResult = MockData.filmInfo

        coEvery { filmsRepository.films() } returns listOf(film)

        Assert.assertArrayEquals(
            listOf(expectedResult).toTypedArray(),
            getFilmsUseCase.invoke().toTypedArray()
        )

    }

}