package com.example.oech.ui.screen.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.oech.data.local.SharedPreferencesService
import com.example.oech.data.network.ApiService
import com.example.oech.data.utils.NavDestinations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val service: ApiService,
    private val sharedPreferencesService: SharedPreferencesService
) : ViewModel() {
    var isLoad by mutableStateOf(true)
    var balance by mutableIntStateOf(0)

    fun load() {
        viewModelScope.launch {
            balance = service.getBalance(sharedPreferencesService.token!!).balance
            isLoad = false
        }
    }

    fun logout(navController: NavHostController) {
        sharedPreferencesService.token = null
        navController.navigate(NavDestinations.SignIn)
    }
}