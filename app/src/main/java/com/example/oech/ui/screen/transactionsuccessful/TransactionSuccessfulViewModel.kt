package com.example.oech.ui.screen.transactionsuccessful

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TransactionSuccessfulViewModel @Inject constructor() : ViewModel() {
    var isSuccessful by mutableStateOf(false)
    var uuid by mutableStateOf("")

}