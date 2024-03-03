package com.example.oech.ui.screen.sendpackage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.oech.R
import com.example.oech.data.model.Destination
import com.example.oech.data.utils.NavDestinations
import com.example.oech.ui.screen.receipt.ReceiptViewModel
import com.example.oech.ui.widgets.RouteHeader
import com.example.oech.ui.widgets.ShadowField

@Composable
fun SendPackageScreen(
    navController: NavHostController,
    receiptViewModel: ReceiptViewModel,
    viewModel: SendPackageViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(107.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.origin),
                contentDescription = "",
                tint = colorScheme.primary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Origin Details",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = colorScheme.onBackground
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        ShadowField(
            label = "Address",
            value = state.address,
            onChange = { viewModel.state = state.copy(address = it) }
        )
        Spacer(modifier = Modifier.height(10.dp))
        ShadowField(
            label = "State,Country",
            value = state.country,
            onChange = { viewModel.state = state.copy(country = it) }
        )
        Spacer(modifier = Modifier.height(10.dp))
        ShadowField(
            label = "Phone number",
            value = state.phone,
            onChange = { viewModel.state = state.copy(phone = it) }
        )
        Spacer(modifier = Modifier.height(10.dp))
        ShadowField(
            label = "Others",
            value = state.others,
            onChange = { viewModel.state = state.copy(others = it) }
        )
        for ((i, destination) in state.destinations.withIndex()) {
            Spacer(modifier = Modifier.height(24.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.destinations),
                    contentDescription = "",
                    tint = colorScheme.primary
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Destination Details",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorScheme.onBackground
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            ShadowField(
                label = "Address",
                value = destination.address,
                onChange = {
                    val newDestinations = state.destinations.toMutableList()
                    newDestinations[i] = destination.copy(address = it)
                    viewModel.state = state.copy(destinations = newDestinations)
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            ShadowField(
                label = "State,Country",
                value = destination.country,
                onChange = {
                    val newDestinations = state.destinations.toMutableList()
                    newDestinations[i] = destination.copy(country = it)
                    viewModel.state = state.copy(destinations = newDestinations)
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            ShadowField(
                label = "Phone number",
                value = destination.phone,
                onChange = {
                    val newDestinations = state.destinations.toMutableList()
                    newDestinations[i] = destination.copy(phone = it)
                    viewModel.state = state.copy(destinations = newDestinations)
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            ShadowField(
                label = "Others",
                value = destination.others,
                onChange = {
                    val newDestinations = state.destinations.toMutableList()
                    newDestinations[i] = destination.copy(others = it)
                    viewModel.state = state.copy(destinations = newDestinations)
                }
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {
            val newDestinations = state.destinations.toMutableList()
            newDestinations.add(Destination())
            viewModel.state = state.copy(destinations = newDestinations)
        }) {
            Icon(
                painter = painterResource(id = R.drawable.add_square),
                contentDescription = "",
                tint = colorScheme.primary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Add destination",
                fontSize = 12.sp,
                color = colorScheme.onSurfaceVariant
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Package Details",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(10.dp))
        ShadowField(
            label = "package items",
            value = state.items,
            onChange = { viewModel.state = state.copy(items = it) }
        )
        Spacer(modifier = Modifier.height(10.dp))
        ShadowField(
            label = "Weight of item(kg)",
            value = state.weight,
            onChange = { viewModel.state = state.copy(weight = it) }
        )
        Spacer(modifier = Modifier.height(10.dp))
        ShadowField(
            label = "Worth of Items",
            value = state.worth,
            onChange = { viewModel.state = state.copy(worth = it) }
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Select delivery type",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            Column(
                Modifier
                    .shadow(5.dp)
                    .background(colorScheme.primary, RoundedCornerShape(8.dp))
                    .weight(1f)
                    .padding(vertical = 13.dp)
                    .clickable {
                        if (state.address.isNotEmpty() &&
                            state.country.isNotEmpty() &&
                            state.phone.isNotEmpty() &&
                            state.items.isNotEmpty() &&
                            state.weight.isNotEmpty() &&
                            state.worth.isNotEmpty() &&
                            state.destinations.none { it.address.isEmpty() || it.country.isEmpty() || it.phone.isEmpty() }
                        ) {
                            viewModel.sendPackage(navController, receiptViewModel)
                        }
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Instant delivery",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                Modifier
                    .shadow(5.dp)
                    .background(colorScheme.background, RoundedCornerShape(8.dp))
                    .weight(1f)
                    .padding(vertical = 13.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.calendar),
                    contentDescription = "",
                    tint = colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Scheduled delivery",
                    color = colorScheme.onSurfaceVariant,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
    RouteHeader(name = "Send a package", navController)
}