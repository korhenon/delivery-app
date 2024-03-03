package com.example.oech.ui.screen.home

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.oech.data.utils.NavDestinations

@Composable
fun HomeScreen(navController: NavHostController) {
    Button(onClick = { navController.navigate(NavDestinations.SendPackage) }) {
        Text(text = "Send package")
    }
}