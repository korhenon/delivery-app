package com.example.oech.ui.screen.newpassword

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.oech.data.local.SharedPreferencesService
import com.example.oech.data.model.ChangePasswordBody
import com.example.oech.data.model.NewPasswordState
import com.example.oech.data.model.SignInBody
import com.example.oech.data.network.ApiService
import com.example.oech.data.utils.NavDestinations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewPasswordViewModel @Inject constructor(
    private val service: ApiService,
    private val sharedPreferences: SharedPreferencesService
) : ViewModel() {
    var code by mutableIntStateOf(0)
    var email by mutableStateOf("")
    var state by mutableStateOf(NewPasswordState())

    fun newPassword(navController: NavController) {
        viewModelScope.launch {
            val response = service.changePassword(ChangePasswordBody(email, state.password, code))
            if (response.token != null) {
                sharedPreferences.token = response.token
                navController.navigate(NavDestinations.Home)
            }
        }
    }
}