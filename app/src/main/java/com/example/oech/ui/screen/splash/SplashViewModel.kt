package com.example.oech.ui.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.oech.data.local.SharedPreferencesService
import com.example.oech.data.utils.NavDestinations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val sharedPreferencesService: SharedPreferencesService
) : ViewModel() {
    fun launch(navController: NavHostController) {
        viewModelScope.launch {
            var navDestination = NavDestinations.Onboard
            if (sharedPreferencesService.lastPage == 3) {
                navDestination = NavDestinations.Holder
            }
            delay(500)
            navController.navigate(navDestination)
        }
    }
}