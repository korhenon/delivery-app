package com.example.oech.ui.screen.receipt

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.oech.data.utils.NavDestinations
import com.example.oech.ui.screen.transactionsuccessful.TransactionSuccessfulViewModel
import com.example.oech.ui.widgets.RouteHeader

@Composable
fun ReceiptScreen(
    navController: NavHostController,
    viewModel: ReceiptViewModel,
    transactionSuccessfulViewModel: TransactionSuccessfulViewModel
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(90.dp))
        Text(
            text = "Package Information",
            fontSize = 16.sp,
            color = colorScheme.primary,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Origin details", fontSize = 12.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "${viewModel.packageInfo.address}, ${viewModel.packageInfo.country}",
            fontSize = 12.sp,
            color = colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = viewModel.packageInfo.phone,
            fontSize = 12.sp,
            color = colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Destination details", fontSize = 12.sp)
        Spacer(modifier = Modifier.height(4.dp))
        for ((i, destination) in viewModel.packageInfo.destinations.withIndex()) {
            Text(
                text = "${i + 1}. ${destination.address}, ${destination.country}",
                fontSize = 12.sp,
                color = colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = destination.phone,
                fontSize = 12.sp,
                color = colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        Text(text = "Destination details", fontSize = 12.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Detail("Package Items", viewModel.packageInfo.items)
        Spacer(modifier = Modifier.height(8.dp))
        Detail("Weight of items", viewModel.packageInfo.weight)
        Spacer(modifier = Modifier.height(8.dp))
        Detail("Worth of Items", viewModel.packageInfo.worth)
        Spacer(modifier = Modifier.height(8.dp))
        Detail("Tracking Number", viewModel.response.UUID)
        Spacer(modifier = Modifier.height(40.dp))
        Box(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(colorScheme.onSurfaceVariant)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Charges",
            fontSize = 16.sp,
            color = colorScheme.primary,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Detail("Delivery Charges", viewModel.response.charges.delivery.toString())
        Spacer(modifier = Modifier.height(8.dp))
        Detail("Instant delivery", viewModel.response.charges.instant_delivery.toString())
        Spacer(modifier = Modifier.height(8.dp))
        Detail("Tax and Service Charges", viewModel.response.charges.tax_and_service.toString())
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(colorScheme.onSurfaceVariant)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Detail(
            "Package total", (viewModel.response.charges.delivery +
                    viewModel.response.charges.instant_delivery +
                    viewModel.response.charges.tax_and_service).toString()
        )
        Spacer(modifier = Modifier.height(45.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            OutlinedButton(
                onClick = {
                    navController.popBackStack()
                },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = colorScheme.primary),
                border = BorderStroke(1.dp, colorScheme.primary),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Edit package",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
            Button(
                onClick = {
                    transactionSuccessfulViewModel.uuid = viewModel.response.UUID
                    navController.navigate(NavDestinations.TransactionSuccessful)
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorScheme.background,
                    containerColor = colorScheme.primary
                ),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Make payment",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
        }
    }
    RouteHeader(name = "Send a package", navController)
}

@Composable
fun Detail(first: String, second: String) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = first,
            fontSize = 12.sp,
            color = colorScheme.onSurfaceVariant
        )
        Text(
            text = second,
            fontSize = 12.sp,
            color = colorScheme.secondary
        )
    }
}