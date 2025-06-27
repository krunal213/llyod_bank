package com.app.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.domain.entities.Film
import com.app.domain.usecase.films.GetFilmsUseCase
import com.app.presentation.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject
import com.app.common.exception.NoConnectivityException
import com.app.presentation.isNetworkAvailable

@HiltViewModel
class FilmsViewModel @Inject constructor(
    val application: Application,
    private val getFilmsUseCase: GetFilmsUseCase
) : ViewModel() {

    private val _showProgressBarMutableStateFlow = MutableStateFlow(false)
    val showProgressBarStateFlow: StateFlow<Boolean> = _showProgressBarMutableStateFlow

    private val _filmsMutableStateFlow = MutableStateFlow<List<Film>>(emptyList())
    val filmsStateFlow: StateFlow<List<Film>> = _filmsMutableStateFlow

    private val _errorMessageMutableSharedFlow = MutableSharedFlow<String>()
    val errorMessageSharedFlow: SharedFlow<String> = _errorMessageMutableSharedFlow

    init {
        getFilms()
    }

    private fun getFilms() {
        viewModelScope.launch {
            try {
                if (application.isNetworkAvailable()) {
                    _showProgressBarMutableStateFlow.emit(true)
                    _filmsMutableStateFlow.emit(getFilmsUseCase())
                    _showProgressBarMutableStateFlow.emit(false)
                }
            } catch (ex: NoConnectivityException) {
                _errorMessageMutableSharedFlow.emit(
                    application.resources.getString(
                        R.string.error_no_internet
                    )
                )
                _showProgressBarMutableStateFlow.emit(false)
            } catch (ex: Exception) {
                _errorMessageMutableSharedFlow.emit(
                    application.resources.getString(
                        R.string.error_something_went_wrong
                    )
                )
                _showProgressBarMutableStateFlow.emit(false)
            }
        }
    }

}