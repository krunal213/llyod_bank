package com.app.llyodbank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.app.presentation.FilmDetailsScreen
import com.app.presentation.FilmsScreen
import com.app.presentation.ui.theme.LlyodBankTheme
import com.app.presentation.view.FilmDetails
import com.app.presentation.view.Films
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LlyodBankTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(WindowInsets.safeDrawing.asPaddingValues()),
                    snackbarHost = { SnackbarHost(snackbarHostState) }
                ) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = FilmsScreen::class) {
                        composable<FilmsScreen> {
                            Films(
                                modifier = Modifier.padding(innerPadding),
                                snackbarHostState = snackbarHostState,
                                onFilmClick = { filmInfo ->
                                    navController.navigate(
                                        FilmDetailsScreen(
                                            id = filmInfo.id,
                                            title = filmInfo.title,
                                            movieBanner = filmInfo.movieBanner,
                                            description = filmInfo.description,
                                            director = filmInfo.director,
                                            releaseDate = filmInfo.releaseDate,
                                            url = filmInfo.url,
                                            runningTime = filmInfo.runningTime
                                        )
                                    )
                                }
                            )
                        }
                        composable<FilmDetailsScreen> { backStackEntry ->
                            FilmDetails(backStackEntry.toRoute<FilmDetailsScreen>())
                        }
                    }
                }
            }
        }
    }
}

