package com.example.oech.ui.screen.forgotpassword

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.oech.data.model.GetValidCodeBody
import com.example.oech.data.network.ApiService
import com.example.oech.data.utils.NavDestinations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val service: ApiService
): ViewModel(){

    var email by mutableStateOf("")

    fun forgotPassword(navController: NavHostController) {
        viewModelScope.launch {
            service.getValidCode(GetValidCodeBody(email))
            navController.navigate(NavDestinations.OTPVerification)
        }
    }
}