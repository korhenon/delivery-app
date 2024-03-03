package com.example.oech.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.oech.R

@Composable
fun RouteHeader(name: String, navController: NavController? = null) {
    Box(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(64.dp)
                .shadow(15.dp)
                .background(colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name,
                fontSize = 16.sp,
                color = colorScheme.onSurface,
                fontWeight = FontWeight.Medium
            )
        }
        if (navController != null) {
            Box(modifier = Modifier.padding(top = 10.dp, start = 5.dp)) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.back_button),
                        contentDescription = "",
                        tint = colorScheme.primary
                    )
                }
            }
        }
    }
}