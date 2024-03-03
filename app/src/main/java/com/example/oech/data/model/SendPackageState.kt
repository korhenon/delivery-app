package com.example.oech.data.model

data class SendPackageState(
    val address: String = "",
    val country: String = "",
    val phone: String = "",
    val others: String = "",
    val destinations: List<Destination> = listOf(Destination()),
    val items: String = "",
    val weight: String = "",
    val worth: String = ""
)
