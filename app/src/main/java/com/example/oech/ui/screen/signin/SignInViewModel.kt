package com.example.oech.ui.screen.signin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.oech.data.local.SharedPreferencesService
import com.example.oech.data.model.SignInBody
import com.example.oech.data.model.SignInResponse
import com.example.oech.data.model.SignInState
import com.example.oech.data.network.ApiService
import com.example.oech.data.utils.NavDestinations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val service: ApiService,
    private val sharedPreferences: SharedPreferencesService
) : ViewModel() {
    var state by mutableStateOf(SignInState())

    fun signIn(navController: NavController) {
        viewModelScope.launch {
            val response = service.signIn(SignInBody(state.email, state.password))
            if (response.token != null) {
                sharedPreferences.token = response.token
                navController.navigate(NavDestinations.Home)
            }
        }
    }
}