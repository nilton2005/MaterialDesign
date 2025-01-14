package com.example.laboratorio05.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun CustomBottomBar( navController: NavHostController) {
    BottomAppBar(

    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){

            IconButton(onClick = { navController.navigate("settings") }) {
                Icon(Icons.Filled.Build, contentDescription = "Build description")
            }
            IconButton(onClick = {navController.navigate("menu") }) {
                Icon(
                    Icons.Filled.Menu,
                    contentDescription = "Menu description",
                )
            }
            IconButton(onClick = { navController.navigate("favorite") }) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite description",
                )
            }
            IconButton(onClick = { navController.navigate("delete") }) {
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = "Delete description",
                )
            }
        }

    }
}
