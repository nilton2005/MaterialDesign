package com.example.laboratorio05

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Composition
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio05.ui.CustomBottomBar
import com.example.laboratorio05.ui.CustomContent
import com.example.laboratorio05.ui.CustomTopBar
import com.example.laboratorio05.ui.StructureUser


@Composable
fun MainNavigation() {
    val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "user") {
            composable("user") { StructureUser(navController, Modifier) }
            composable("casa") {CustomScaffold(navController)  }
        }

}





@Composable
fun CustomScaffold(navController: NavHostController) {
    Scaffold(
        // Barra superior
        topBar = { CustomTopBar(
            navController = navController,
            modifier = Modifier
        ) },
        bottomBar = { CustomBottomBar() },
        content = { CustomContent(it) }


        // Barra inferior
    )
}
