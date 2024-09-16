package com.example.laboratorio05.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.laboratorio05.R
import com.example.laboratorio05.ui.theme.theme.Purple200
import com.example.laboratorio05.ui.theme.theme.Purple500
import com.example.laboratorio05.ui.theme.theme.Purple700
import com.example.laboratorio05.ui.theme.theme.Teal200


@Composable
fun StructureUser(navController: NavHostController, modifier: Modifier) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        // icon buttun to back
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            IconButton(onClick = { navController.navigate("casa") }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription ="Back", tint = Color.White  )
            }
        }
        GreetingAvatar()
        GreetingInformation(name = "Stefan", email = "stefan@gmail.com")
        GreetingImages(image1 = painterResource(id = R.drawable.image1), image2 = painterResource(id = R.drawable.image2) , 
            image3 = painterResource(id =R.drawable.image3 ) , image4 = painterResource(id = R.drawable.image3))

    }
}

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(16.dp),
    extraLarge = CircleShape
)


@Composable
fun GreetingAvatar(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(bottom = 8.dp)
            .background(Purple700, Shapes.large)
            .padding(16.dp)

    ) {
        Image( // Replace with your actual avatar image
            painter = painterResource(id = R.drawable.image5),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape) // Circular shape for the avatar
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Stefan",
            style = typography.bodyLarge,
            color = Color.White

        )
    }
}

@Composable
fun GreetingInformation(
    name: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .background(Purple200, Shapes.large)
            .padding(16.dp)
    ) {
        Text(text = "Name: $name", style = typography.headlineMedium)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Email: $email", style = typography.headlineMedium)
    }
}

@Composable
fun GreetingImages(
    image1: Painter,
    image2: Painter,
    image3: Painter,
    image4: Painter,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(6) { index ->
            Card(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .clip(Shapes.medium)
                    .background(color = Purple500),
            ) {
                when (index) {
                    0 -> Image(
                        painter = image1,
                        contentDescription = null
                    )

                    1 -> Image(
                        painter = image2,
                        contentDescription = null
                    )

                    2 -> Image(
                        painter = image3,
                        contentDescription = null
                    )

                    3 -> Image(
                        painter = image4,
                        contentDescription = null
                    )
                }
            }
        }
    }
}






