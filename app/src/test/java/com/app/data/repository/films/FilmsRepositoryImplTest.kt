package com.app.data.repository.films

import com.app.data.repository.films.datasource.network.FilmsNetworkDataSource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class FilmsRepositoryImplTest {

    lateinit var filmsRepository: FilmsRepository
    lateinit var filmsNetworkDataSource: FilmsNetworkDataSource

    @Before
    fun setUp() {
        filmsNetworkDataSource = mockk<FilmsNetworkDataSource>()
        filmsRepository = FilmsRepositoryImpl(filmsNetworkDataSource)
    }

    @Test
    fun test_to_verify_network_datasource_is_called_or_not() = runTest {
        coEvery { filmsNetworkDataSource.films() } returns listOf(mockk())

        filmsRepository.films()

        coVerify { filmsNetworkDataSource.films() }
    }
}