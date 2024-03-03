package com.example.oech.data.model

data class SendPackageBody(
    val origin_details: Destination,
    val delivery_details: List<Destination>,
    val package_details: PackageDetails
)
