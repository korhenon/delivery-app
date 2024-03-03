package com.example.oech.data.utils

import com.example.oech.R
import com.example.oech.data.model.BottomNavigationRoute


val BottomNavigationRoutes = listOf(
    BottomNavigationRoute(NavDestinations.Home, R.drawable.home, "Home"),
    BottomNavigationRoute(NavDestinations.Wallet, R.drawable.wallet, "Wallet"),
    BottomNavigationRoute(NavDestinations.Track, R.drawable.track, "Track"),
    BottomNavigationRoute(NavDestinations.Profile, R.drawable.profile, "Profile")
)