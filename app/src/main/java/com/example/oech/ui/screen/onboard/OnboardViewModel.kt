package com.example.oech.ui.screen.onboard

import androidx.lifecycle.ViewModel
import com.example.oech.data.utils.OnboardPage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardViewModel @Inject constructor(): ViewModel() {
    val page = OnboardPage("", "", 0)
    val queueSize = 3
    val buttonText = ""
    val navDestination = ""

    fun next() {

    }
    fun skip() {

    }
}