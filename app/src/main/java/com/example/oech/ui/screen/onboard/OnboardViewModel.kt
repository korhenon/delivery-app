package com.example.oech.ui.screen.onboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.oech.data.local.SharedPreferencesService
import com.example.oech.data.utils.OnboardPage
import com.example.oech.data.utils.OnboardPages
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardViewModel @Inject constructor(
//    val sharedPreferences: SharedPreferencesService
) : ViewModel() {
    //    var pageId by mutableIntStateOf(sharedPreferences.lastPage)
    var pageId = 0
    val isLast get() = pageId == 2
    val page get() = OnboardPages[pageId]
    val queueSize get() = 3 - pageId
    val buttonText get() = if (isLast) "Sign Up" else "Next"
    val navDestination get() = if (isLast) "Holder" else ""

    fun next() {
        if (pageId < 2) {
            pageId++
//            sharedPreferences.lastPage = pageId
        }
    }

    fun skip() {
//        sharedPreferences.lastPage = 3
    }
}