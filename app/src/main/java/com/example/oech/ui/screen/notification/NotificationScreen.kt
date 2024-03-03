package com.example.oech.ui.screen.notification

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.oech.R
import com.example.oech.ui.widgets.RouteHeader

@Composable
fun NotificationScreen(navController: NavHostController) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(180.dp))
        Icon(
            painter = painterResource(id = R.drawable.notification),
            contentDescription = "",
            tint = colorScheme.onSurfaceVariant,
            modifier = Modifier.size(85.dp)
        )
        Spacer(modifier = Modifier.height(18.dp))
        Text(
            text = "You have no notifications",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = colorScheme.onBackground
        )
    }
    RouteHeader(name = "Notification", navController = navController)
}