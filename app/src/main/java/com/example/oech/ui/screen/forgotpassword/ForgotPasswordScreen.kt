package com.example.oech.ui.screen.forgotpassword

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.oech.common.isEmailValid
import com.example.oech.data.utils.NavDestinations
import com.example.oech.ui.screen.otpverification.OTPVerificationViewModel
import com.example.oech.ui.widgets.FieldWithLabel
import com.example.oech.ui.widgets.MaxWidthButton

@Composable
fun ForgotPasswordScreen(
    navController: NavHostController,
    otpVerificationViewModel: OTPVerificationViewModel,
    viewModel: ForgotPasswordViewModel = hiltViewModel()
) {
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
        Spacer(modifier = Modifier.height(20.dp))
        FieldWithLabel(
            label = "Email Address",
            placeholder = "***********@mail.com",
            value = viewModel.email,
            onChange = {
                viewModel.email = it
            },
            isError = !viewModel.email.isEmailValid()
        )
        Spacer(modifier = Modifier.height(60.dp))
        MaxWidthButton(text = "Send OTP", onClick = {
            otpVerificationViewModel.email = viewModel.email
            viewModel.forgotPassword(navController)
        }, enabled = viewModel.email.isNotEmpty() && viewModel.email.isEmailValid())
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = MaterialTheme.colorScheme.onSurfaceVariant)) {
                    append("Remember password? Back to ")
                }
                withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                    append("Sign in")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(NavDestinations.SignIn)
                },
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
    }
}