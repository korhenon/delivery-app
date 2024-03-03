package com.example.oech.ui.screen.profile

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.oech.R
import com.example.oech.data.utils.NavDestinations
import com.example.oech.ui.theme.ErrorRed
import com.example.oech.ui.widgets.RouteHeader

@Composable
fun ProfileScreen(navController: NavHostController, viewModel: ProfileViewModel = hiltViewModel()) {
    var hide by remember { mutableStateOf(false) }
    var switch by remember { mutableStateOf(false) }
    if (!viewModel.isLoad) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.user_photo),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(50.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Column {
                        Text(
                            text = "Hello Ken",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = colorScheme.onBackground
                        )
                        Text(text = buildAnnotatedString {
                            append("Current balance: ")
                            withStyle(SpanStyle(color = colorScheme.primary)) {
                                append(if (!hide) viewModel.balance.toString() else "***")
                            }
                        }, fontSize = 12.sp, color = colorScheme.onBackground)
                    }
                }
                IconButton(onClick = { hide = !hide }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_visibility_off_24),
                        contentDescription = ""
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Enable dark Mode",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Switch(
                        checked = switch,
                        onCheckedChange = { switch = !switch },
                        colors = SwitchDefaults.colors(
                            uncheckedTrackColor = colorScheme.onSurfaceVariant,
                            uncheckedThumbColor = colorScheme.background,
                            uncheckedBorderColor = Color.Transparent
                        ),
                        modifier = Modifier.height(26.dp)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                ProfileCard(
                    icon = R.drawable.edit_profile,
                    title = "Edit Profile",
                    text = "Name, phone no, address, email"
                )
                Spacer(modifier = Modifier.height(12.dp))
                ProfileCard(
                    icon = R.drawable.statements,
                    title = "Statements & Reports",
                    text = "Download transaction details, orders, deliveries"
                )
                Spacer(modifier = Modifier.height(12.dp))
                ProfileCard(
                    icon = R.drawable.notification,
                    title = "Notification Settings",
                    text = "mute, unmute, set location & tracking setting"
                ) {
                    navController.navigate(NavDestinations.Notifications)
                }
                Spacer(modifier = Modifier.height(12.dp))
                ProfileCard(
                    icon = R.drawable.wallet_2,
                    title = "Card & Bank account settings",
                    text = "change cards, delete card details"
                ) {
                    navController.navigate(NavDestinations.AddPaymentMethod)
                }
                Spacer(modifier = Modifier.height(12.dp))
                ProfileCard(
                    icon = R.drawable.referals,
                    title = "Referrals",
                    text = "check no of friends and earn"
                )
                Spacer(modifier = Modifier.height(12.dp))
                ProfileCard(
                    icon = R.drawable.about_us,
                    title = "About Us",
                    text = "know more about us, terms and conditions"
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    Modifier
                        .fillMaxWidth()
                        .shadow(8.dp)
                        .background(colorScheme.background)
                        .padding(16.dp)
                        .clickable { viewModel.logout(navController) },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.log_out),
                            contentDescription = "",
                            tint = ErrorRed
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Column {
                            Text(text = "Log Out", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                        }
                    }
                    Icon(
                        painter = painterResource(R.drawable.forward_arrow),
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    } else viewModel.load()
}

@Composable
fun ProfileCard(icon: Int, title: String, text: String, onClick: () -> Unit = {}) {
    Row(
        Modifier
            .fillMaxWidth()
            .shadow(8.dp)
            .background(colorScheme.background)
            .padding(12.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = painterResource(id = icon), contentDescription = "")
            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = text, fontSize = 12.sp, color = colorScheme.onSurfaceVariant)
            }
        }
        Icon(painter = painterResource(R.drawable.forward_arrow), contentDescription = "")
    }
}