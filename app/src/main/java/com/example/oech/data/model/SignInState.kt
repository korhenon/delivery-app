package com.example.oech.data.model

data class SignInState(
    val email: String = "",
    val password: String = "",
    val rememberPassword: Boolean = false
)
