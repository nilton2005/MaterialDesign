package com.example.laboratorio05.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Feedback
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SettingsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F0F0)) // Light gray background
            .padding(16.dp)
    ) {
        // Back button with a circular background
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
        Spacer(modifier = Modifier.height(16.dp))

        SettingItem(
            icon = Icons.Filled.Person,
            title = "User Settings",
            subtitle = "Profile, Business Profile",
            backgroundColor = Color(0xFFBBDEFB) //Light blue
        ) {
            // Handle navigation to user settings
        }
        Spacer(modifier = Modifier.height(16.dp))

        SettingItem(
            icon = Icons.Filled.ShoppingCart,
            title = "Transaction Settings",
            subtitle = "Money, Taxes, Payment Types",
            backgroundColor = Color(0xFFC8E6C9) // Light green
        ) {
            // Handle navigation to transaction settings
        }
        Spacer(modifier = Modifier.height(16.dp))

        SettingItem(
            icon = Icons.Filled.Lock,
            title = "Privacy and Security",
            backgroundColor = Color(0xFFF8BBD0) // Light pink
        ) {
            // Handle navigation to privacy and security settings
        }
        Spacer(modifier = Modifier.height(16.dp))

        SettingItem(
            icon = Icons.Outlined.Feedback,
            title = "Comments and Feedback",
            backgroundColor = Color(0xFFFFF9C4) // Light yellow
        ) {
            // Handle navigation to feedback section
        }
    }
}

@Composable
fun SettingItem(
    icon: ImageVector,
    title: String,
    subtitle: String? = null,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp)) // Rounded corners
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            if (subtitle != null) {
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}