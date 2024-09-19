package com.example.laboratorio05.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.laboratorio05.R

@Composable
fun CustomContent(padding: PaddingValues) {
    val imageList = listOf(
        R.drawable.lita,
        R.drawable.marco,
        R.drawable.walker // Asegúrate de reemplazar con imágenes reales
    )

    var currentImageIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .background(Color.Black) // Fondo negro
    ) {
        // Carrusel de imágenes de cantantes
        Carousel(
            images = imageList,
            currentIndex = currentImageIndex,
            onImageChange = { index -> currentImageIndex = index }
        )

        Spacer(modifier = Modifier.height(52.dp))

        // Contenido de la tarjeta
        MusicCard()
    }
}


@Composable
fun Carousel(images: List<Int>, currentIndex: Int, onImageChange: (Int) -> Unit) {
    // Estado del pager con el número de páginas definido por images.size
    val pagerState = rememberPagerState(pageCount = { images.size })

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxWidth(),
    ) { page ->
        Image(
            painter = painterResource(id = images[page]),
            contentDescription = "Singer Image",
            modifier = Modifier
                .clip(CircleShape)
                .width(300.dp),
            contentScale = ContentScale.Crop
        )
    }

    LaunchedEffect(pagerState.currentPage) {
        onImageChange(pagerState.currentPage)
    }
}

@Composable
fun MusicCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(CircleShape)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .clip(CircleShape),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.album), // Reemplaza con la imagen real del álbum
                contentDescription = "Music Album",
                modifier = Modifier
                    .size(400.dp)
                    .clip(RoundedCornerShape(2.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = { /* Retroceder */ }) {
                    Icon(
                        imageVector = Icons.Filled.SkipPrevious,
                        contentDescription = "Previous",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                IconButton(onClick = { /* Reproducir/Pausar */ }) {
                    Icon(
                        imageVector = Icons.Filled.PlayArrow, // Usa PlayArrow o Pause según el estado
                        contentDescription = "Play/Pause",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                IconButton(onClick = { /* Avanzar */ }) {
                    Icon(
                        imageVector = Icons.Filled.SkipNext,
                        contentDescription = "Next",
                        tint = Color.White
                    )
                }
            }
        }
    }
}
