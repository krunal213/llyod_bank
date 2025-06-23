package com.app.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.app.MockData
import com.app.common.exception.NoConnectivityException
import com.app.llyodbank.LlyodBankApplication
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FilmsViewModelIntegrationTest {

    private lateinit var getFilmsUseCase: GetFilmsUseCase
    private lateinit var viewModel: FilmsViewModel
    private lateinit var app: LlyodBankApplication
    private val testDispatcher = UnconfinedTestDispatcher()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        app = mockk<LlyodBankApplication>(relaxed = true)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun test_when_filmsviewmodel_initialize_and_then_return_films() {
        val expectedList = MockData.filmInfoList

        getFilmsUseCase = mockk<GetFilmsUseCase>()

        coEvery { getFilmsUseCase() } returns expectedList

        viewModel = FilmsViewModel(app, getFilmsUseCase)

        testDispatcher.scheduler.advanceUntilIdle()

        Assert.assertArrayEquals(
            expectedList.toTypedArray(),
            viewModel.filmsStateFlow.value.toTypedArray()
        )
    }

    @Test
    fun test_when_throw_io_exception_and_then_return_error_message()  {

        val expectedErrorMessage = MockData.noInternetConnectionMessage

        every { app.resources.getString(any()) } returns expectedErrorMessage

        getFilmsUseCase = mockk<GetFilmsUseCase>()

        coEvery { getFilmsUseCase() } coAnswers {
            delay(2000)
            throw NoConnectivityException()
        }

        viewModel = FilmsViewModel(app, getFilmsUseCase)

        val liveData = viewModel.errorMessageSharedFlow.asLiveData()

        liveData.observeForever(object : Observer<String> {
            override fun onChanged(actualErrorMessage: String) {
                assertEquals(expectedErrorMessage, actualErrorMessage)
                liveData.removeObserver(this)
            }
        })

    }

    @Test
    fun test_when_throw_exception_and_then_return_error_message() = runTest {

        val expectedErrorMessage = MockData.somethingWentWrongMessage

        every { app.resources.getString(any()) } returns expectedErrorMessage

        getFilmsUseCase = mockk<GetFilmsUseCase>()

        coEvery { getFilmsUseCase() } coAnswers {
            delay(2000)
            throw Exception()
        }

        viewModel = FilmsViewModel(app, getFilmsUseCase)

        val liveData = viewModel.errorMessageSharedFlow.asLiveData()

        liveData.observeForever(object : Observer<String> {
            override fun onChanged(actualErrorMessage: String) {
                assertEquals(expectedErrorMessage, actualErrorMessage)
                liveData.removeObserver(this)
            }
        })

    }

}

