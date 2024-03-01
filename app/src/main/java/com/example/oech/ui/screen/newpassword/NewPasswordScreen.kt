package com.example.oech.ui.screen.newpassword

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.oech.ui.widgets.MaxWidthButton
import com.example.oech.ui.widgets.PasswordField

@Composable
fun NewPasswordScreen(
    navController: NavHostController,
    viewModel: NewPasswordViewModel
) {
    val state = viewModel.state
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(110.dp))
        Text(
            text = "Welcome Back",
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Fill in your email and password to continue",
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(70.dp))
        PasswordField(label = "Password",
            value = state.password,
            onChange = {
                viewModel.state = state.copy(password = it)
            })
        Spacer(modifier = Modifier.height(24.dp))
        PasswordField(label = "Confirm Password",
            value = state.confirmPassword,
            onChange = {
                viewModel.state = state.copy(confirmPassword = it)
            })
        Spacer(modifier = Modifier.height(70.dp))
        MaxWidthButton(
            text = "Log in",
            onClick = { viewModel.newPassword(navController) },
            enabled = state.password.isNotEmpty() && state.password == state.confirmPassword
        )
    }
}