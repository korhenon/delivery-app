package com.example.oech.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.oech.R

@Composable
fun SplashScreen(navController: NavHostController, viewModel: SplashViewModel = hiltViewModel()) {
    viewModel.launch(navController)
    Box(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 80.dp), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "",
            Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

    }
}