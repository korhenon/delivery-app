package com.example.oech.ui.screen.sendpackage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.oech.data.local.SharedPreferencesService
import com.example.oech.data.model.Destination
import com.example.oech.data.model.PackageDetails
import com.example.oech.data.model.SendPackageBody
import com.example.oech.data.model.SendPackageState
import com.example.oech.data.network.ApiService
import com.example.oech.data.utils.NavDestinations
import com.example.oech.ui.screen.receipt.ReceiptViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SendPackageViewModel @Inject constructor(
    private val service: ApiService,
    private val sharedPreferencesService: SharedPreferencesService
) : ViewModel() {
    var state by mutableStateOf(SendPackageState())

    fun sendPackage(navController: NavHostController, receiptViewModel: ReceiptViewModel) {
        viewModelScope.launch {
            val response = service.sendPackage(
                sharedPreferencesService.token!!,
                SendPackageBody(
                    Destination(state.address, state.country, state.phone),
                    state.destinations,
                    PackageDetails(state.items, state.weight.toInt(), state.worth.toInt())
                )
            )
            receiptViewModel.packageInfo = state
            receiptViewModel.response = response
            navController.navigate(NavDestinations.Receipt)
        }
    }
}