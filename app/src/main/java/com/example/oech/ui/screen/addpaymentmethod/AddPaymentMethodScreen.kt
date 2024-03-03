package com.example.oech.ui.screen.addpaymentmethod

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.oech.ui.widgets.RouteHeader

@Composable
fun AddPaymentMethodScreen(navController: NavHostController) {
    RouteHeader(name = "Add Payment method", navController = navController)
}