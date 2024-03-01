package com.example.oech.ui.screen.otpverification

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.oech.data.network.ApiService
import com.example.oech.data.utils.NavDestinations
import com.example.oech.ui.screen.newpassword.NewPasswordViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OTPVerificationViewModel @Inject constructor(
    private val service: ApiService
) : ViewModel() {
    var email by mutableStateOf("")
    var code by mutableStateOf(listOf("", "", "", "", "", ""))
    var isError by mutableStateOf(false)
    val isButtonEnabled: Boolean
        get() {
            var r = true
            for (x in code) {
                r = r && x.isNotEmpty()
            }
            return r
        }

    fun checkCode(navController: NavController, newPasswordViewModel: NewPasswordViewModel) {
        viewModelScope.launch {
            isError = service.checkValidCode(email, code.joinToString("")).message == "fault"
            if (!isError) {
                navController.navigate(NavDestinations.NewPassword)
                newPasswordViewModel.email = email
                newPasswordViewModel.code = code.joinToString("").toInt()
            }
        }
    }
}