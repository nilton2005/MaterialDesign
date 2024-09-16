package com.example.laboratorio05.ui

import android.view.Menu
import android.view.MenuInflater
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.laboratorio05.R
@Composable
fun MenuScreen(navController: NavController) {
    var darkMode by remember { mutableStateOf(false) }
    var notifications by remember { mutableStateOf(true) }
    var language by remember { mutableStateOf("English") }
    val languages = listOf("English", "Spanish", "French")
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(if (darkMode) Color.DarkGray else Color.LightGray)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.padding(24.dp))

        IconButton(
            onClick = { navController.navigate("casa") },
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.White)
                .padding(4.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Text(
            text = "Menu",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = if (darkMode) Color.White else Color.Black
            )
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Language setting with dropdown
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Language,
                contentDescription = "Language",
                modifier = Modifier.size(24.dp),
                tint = if (darkMode) Color.White else Color.Black
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Language",
                style = MaterialTheme.typography.bodyLarge,
                color = if (darkMode) Color.White else Color.Black
            )
            Spacer(modifier = Modifier.weight(1f))
            OutlinedButton(
                onClick = { expanded = true },
                modifier = Modifier.widthIn(min = 80.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = if (darkMode) Color.White else Color.Black
                )
            ) {
                Text(language)
                Icon(
                    Icons.Filled.ArrowDropDown,
                    contentDescription = null
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                languages.forEach { lang ->
                    DropdownMenuItem(
                        onClick = {
                            language = lang
                            expanded = false
                        },
                        text = { Text(text = lang) }  // Se pasa el idioma seleccionado como Composable
                    )
                }

            }
        }

        // Example MenuItem usage
        MenuItem(
            icon = Icons.Filled.DarkMode,
            title = "Dark Mode",
            isChecked = darkMode,
            onCheckedChange = { darkMode = !darkMode }
        )
    }
}

@Composable
fun MenuItem(
    icon: ImageVector,
    title: String,
    isChecked: Boolean,
    onCheckedChange: () -> Unit
) {
    val darkMode = isSystemInDarkTheme()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCheckedChange() }
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(24.dp),
            tint = if (darkMode) Color.White else Color.Black
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            color = if (darkMode) Color.White else Color.Black
        )
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = isChecked,
            onCheckedChange = { onCheckedChange() },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xFF6200EE), // Purple
                checkedTrackColor = Color(0xFFBB86FC)
            )
        )
    }
}
