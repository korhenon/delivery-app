package com.example.oech.data.model

data class SignUpState(
    val name: String = "",
    val phone: String = "",
    val email: String = "",
    val password: String = "",
    val passwordConfirmation: String = "",
    val privacyPolicy: Boolean = false
)
