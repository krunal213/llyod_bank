package com.app.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.app.presentation.FilmDetailsScreen
import com.app.presentation.R

@Composable
fun FilmDetails(filmDetailsScreen: FilmDetailsScreen) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = rememberAsyncImagePainter(filmDetailsScreen.movieBanner),
            contentDescription = stringResource(R.string.post_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
        )
        filmDetailsScreen.title?.let {
            Text(
                it,
                fontWeight = FontWeight.Bold,
                style = TextStyle(fontSize = 40.sp),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                maxLines = 2
            )
        }
        Row(
            modifier = Modifier
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            filmDetailsScreen.releaseDate?.let {
                Text(
                    it,
                    fontSize = 20.sp,
                )
            }
            filmDetailsScreen.runningTime?.let {
                Text(
                    "$it min",
                    fontSize = 20.sp,
                )
            }
        }
        filmDetailsScreen.description?.let {
            Text(
                it,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                overflow = TextOverflow.Ellipsis,
                maxLines = 5
            )
        }
        filmDetailsScreen.director?.let {
            Text(
                it, fontSize = 12.sp, modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun FilmDetailsPreview() {
    Box() {
        FilmDetails(FilmDetailsScreen())
    }

}

