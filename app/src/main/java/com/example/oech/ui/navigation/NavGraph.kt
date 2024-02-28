package com.example.oech.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.oech.data.utils.NavDestinations
import com.example.oech.ui.screen.onboard.OnboardScreen
import com.example.oech.ui.screen.splash.SplashScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavDestinations.Splash) {
        composable(NavDestinations.Splash) {
            SplashScreen(navController)
        }
        composable(NavDestinations.Onboard) {
            OnboardScreen(navController)
        }
        composable(NavDestinations.Holder) {

        }
    }
}