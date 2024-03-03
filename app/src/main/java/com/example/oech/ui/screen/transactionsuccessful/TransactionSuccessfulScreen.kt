package com.example.oech.ui.screen.transactionsuccessful

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.oech.R
import com.example.oech.data.utils.NavDestinations
import com.example.oech.ui.widgets.MaxWidthButton
import kotlinx.coroutines.delay

@Composable
fun TransactionSuccessfulScreen(
    navController: NavHostController,
    viewModel: TransactionSuccessfulViewModel
) {
    LaunchedEffect(key1 = viewModel.isSuccessful) {
        if (!viewModel.isSuccessful) {
            delay(5000)
            viewModel.isSuccessful = true
        }
    }
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        if (!viewModel.isSuccessful) {
            val infiniteTransition = rememberInfiniteTransition(label = "")
            val angle by infiniteTransition.animateFloat(
                initialValue = 0F,
                targetValue = 360F,
                animationSpec = infiniteRepeatable(
                    animation = tween(1000, easing = LinearEasing)
                ), label = ""
            )
            Image(
                painter = painterResource(R.drawable.spinner),
                contentDescription = "",
                modifier = Modifier
                    .size(120.dp)
                    .rotate(angle),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(100.dp))
        } else {
            Image(
                painter = painterResource(R.drawable.successful),
                contentDescription = "",
                modifier = Modifier
                    .size(120.dp),
                contentScale = ContentScale.Crop
            )
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(100.dp), contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    text = "Transaction Successful",
                    fontSize = 24.sp,
                    color = colorScheme.onBackground, fontWeight = FontWeight.Medium
                )
            }
        }

        Text(
            text = "Your rider is on the way to your destination",
            fontSize = 14.sp,
            color = colorScheme.onBackground
        )
        Text(
            text = buildAnnotatedString {
                append("Tracking Number: ")
                withStyle(SpanStyle(color = colorScheme.primary)) {
                    append(viewModel.uuid)
                }
            },
            fontSize = 14.sp,
            color = colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(140.dp))
        MaxWidthButton(
            text = "Track my item",
            onClick = { navController.navigate(NavDestinations.Track) })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedButton(
            onClick = {
                navController.navigate(NavDestinations.Home)
            },
            colors = ButtonDefaults.outlinedButtonColors(contentColor = colorScheme.primary),
            border = BorderStroke(1.dp, colorScheme.primary),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Go back to homepage",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 10.dp)
            )
        }
    }
}