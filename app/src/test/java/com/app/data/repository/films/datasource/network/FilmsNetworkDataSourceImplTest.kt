package com.app.data.repository.films.datasource.network

import com.app.MockData
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class FilmsNetworkDataSourceImplTest {

    private lateinit var filmsNetworkDataSource: FilmsNetworkDataSource
    private lateinit var filmsService: FilmsService

    @Before
    fun setUp() {
        filmsService = mockk<FilmsService>()
        filmsNetworkDataSource = FilmsNetworkDataSourceImpl(filmsService)
    }

    @Test
    fun test_to_verify_network_datasource_is_called_or_not() = runTest {
        val expectedFilmList = listOf(MockData.film, MockData.film)

        coEvery { filmsService.films() } returns expectedFilmList

        assertArrayEquals(
            expectedFilmList.toTypedArray(),
            filmsNetworkDataSource.films().toTypedArray()
        )
    }

}