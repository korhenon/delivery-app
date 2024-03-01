package com.example.oech.common

fun String.isEmailValid(): Boolean {
    if (this.isEmpty()) return true
    val accepted = "1234567890qwertyuiopasdfghjklzxcvbnm."
    val split = this.split("@")
    if (split.size != 2) return false
    var isNameValid = split[0].isNotEmpty()
    for (i in split[0]) {
        isNameValid = isNameValid && i in accepted
    }
    var isDomain = split[1].isNotEmpty()
    for (i in split[1]) {
        isDomain = isDomain && i in accepted
    }
    return isNameValid && isDomain
}