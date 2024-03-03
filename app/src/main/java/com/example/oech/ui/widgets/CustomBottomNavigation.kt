package com.example.oech.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.oech.data.utils.BottomNavigationRoutes

@Composable
fun CustomBottomNavigation(
    route: String,
    navController: NavController,
    hasHeader: Boolean = false,
    content: @Composable () -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        content()
        Spacer(modifier = Modifier.height(70.dp))
    }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Row(
            Modifier
                .shadow(10.dp)
                .fillMaxWidth()
                .height(70.dp)
                .background(colorScheme.background)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for (item in BottomNavigationRoutes) {
                Column(
                    Modifier
                        .fillMaxHeight()
                        .clickable {
                            navController.navigate(item.route) {
                                popUpTo(route) {
                                    inclusive = true
                                }
                            }
                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .height(2.dp)
                            .width(35.dp)
                            .background(
                                if (route == item.route) colorScheme.primary else colorScheme.background,
                                CircleShape
                            )
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = "",
                            tint = if (route == item.route) colorScheme.primary else colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = item.text,
                            color = if (route == item.route) colorScheme.primary else colorScheme.onSurfaceVariant,
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                    }
                }
            }
        }
    }
    if (hasHeader) {
        RouteHeader(name = route)
    }
}