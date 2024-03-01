package com.example.oech.ui.screen.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.oech.common.isEmailValid
import com.example.oech.data.model.SignUpBody
import com.example.oech.data.model.SignUpState
import com.example.oech.data.network.ApiService
import com.example.oech.data.utils.NavDestinations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val service: ApiService
) : ViewModel() {
    var state by mutableStateOf(SignUpState())
    val canSignUp get() = state.password == state.passwordConfirmation && state.privacyPolicy && state.email.isEmailValid()
    fun signUp(navController: NavController) {
        viewModelScope.launch {
            service.signUp(SignUpBody(state.name, state.phone, state.email, state.password))
            navController.navigate(NavDestinations.SignIn)
        }
    }
}