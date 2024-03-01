package com.example.oech.data.model

data class ChangePasswordBody(
    val email: String,
    val password: String,
    val code: Int,
)
