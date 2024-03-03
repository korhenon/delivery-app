package com.example.oech.ui.screen.receipt

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.oech.data.model.Charges
import com.example.oech.data.model.PackageResponse
import com.example.oech.data.model.SendPackageState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReceiptViewModel @Inject constructor() : ViewModel() {
    fun makePayment() {
        TODO("Not yet implemented")
    }

    var packageInfo by mutableStateOf(SendPackageState())
    var response by mutableStateOf(PackageResponse("", Charges(0, 0, 0)))
}