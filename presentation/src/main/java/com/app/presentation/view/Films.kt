package com.app.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import com.app.domain.entities.FilmInfo
import com.app.presentation.R
import com.app.presentation.viewmodel.FilmsViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun Films(
    modifier: Modifier,
    snackbarHostState: SnackbarHostState,
    viewModel: FilmsViewModel = hiltViewModel(),
    onFilmClick: (filmInfo: FilmInfo) -> Unit
) {

    val films by viewModel.filmsStateFlow.collectAsStateWithLifecycle()
    val showProgressBar by viewModel.showProgressBarStateFlow.collectAsStateWithLifecycle()
    val columnCount = 2

    if (showProgressBar) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
    LazyVerticalGrid(columns = GridCells.Fixed(columnCount)) {
        items(films.size) { index ->
            val film = films[index]
            FilmCard(filmInfo = film, onFilmClick)
        }
    }
    LaunchedEffect(Unit) {
        viewModel.errorMessageSharedFlow.collectLatest { message ->
            snackbarHostState.showSnackbar(message)
        }
    }
}

@Composable
private fun FilmCard(filmInfo: FilmInfo, onFilmClick: (filmInfo: FilmInfo) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(0.dp),
        onClick = {
            onFilmClick(filmInfo)
        }
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = rememberAsyncImagePainter(filmInfo.movieBanner),
                contentDescription = stringResource(R.string.title_photos),
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop,
            )
            filmInfo.title?.let {
                Text(
                    it,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            filmInfo.releaseDate?.let {
                Text(
                    it,
                    fontSize = 14.sp,
                    maxLines = 1
                )
            }
        }
    }

}

@Preview
@Composable
fun FilmCardPreview() {
    Box() {
        FilmCard(
            FilmInfo(
                movieBanner = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/npOnzAbLh6VOIu3naU5QaEcTepo.jpg",
                title = "Castle in the Sky",
                releaseDate = "1780"
            ),
            {

            }
        )
    }

}
