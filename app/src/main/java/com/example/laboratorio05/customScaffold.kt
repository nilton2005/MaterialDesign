package com.example.laboratorio05

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio05.ui.CustomBottomBar
import com.example.laboratorio05.ui.CustomContent
import com.example.laboratorio05.ui.CustomFAB
import com.example.laboratorio05.ui.CustomTopBar
import com.example.laboratorio05.ui.MenuScreen
import com.example.laboratorio05.ui.SettingsScreen
import com.example.laboratorio05.ui.StructureUser
import kotlinx.coroutines.launch


@Composable
fun MainNavigation() {
    val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "user") {
            composable("user") { StructureUser(navController, Modifier) }
            composable("casa") {CustomScaffold(navController)  }
            composable("settings") { SettingsScreen(navController) }
            composable("menu") { MenuScreen(navController)  }


        }

}





@Composable
fun CustomScaffold(navController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // Contenido del Drawer (Menú lateral)
            DrawerContent(navController)
        }
    ) {
        Scaffold(
            // Barra superior
            topBar = {
                CustomTopBar(
                    navController = navController,
                    modifier = Modifier
                )
            },
            bottomBar = {CustomBottomBar( navController)  },
            floatingActionButton = {CustomFAB()},
            content = { CustomContent(it) }



            // Barra inferior
        )
    }
}


@Composable
fun DrawerContent(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Item 1", modifier = Modifier.clickable {
            // Navegar a otras pantallas desde el Drawer
            navController.navigate("home")
        })
        Text("Item 2", modifier = Modifier.clickable {
            navController.navigate("profile")
        })
    }
}