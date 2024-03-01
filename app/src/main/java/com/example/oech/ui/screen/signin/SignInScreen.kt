package com.example.oech.ui.screen.signin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.oech.ui.widgets.FieldWithLabel
import com.example.oech.ui.widgets.GoogleButton
import com.example.oech.ui.widgets.MaxWidthButton
import com.example.oech.ui.widgets.PasswordField

@Composable
fun SignInScreen(navController: NavHostController, viewModel: SignInViewModel = hiltViewModel()) {
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
            color = colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Fill in your email and password to continue",
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(20.dp))
        FieldWithLabel(
            label = "Email Address",
            placeholder = "***********@mail.com",
            value = state.email,
            onChange = {
                viewModel.state = state.copy(email = it)
            },
            isError = !state.email.isEmailValid()
        )
        Spacer(modifier = Modifier.height(24.dp))
        PasswordField(label = "Password", value = state.password, onChange = {
            viewModel.state = state.copy(password = it)
        })
        Spacer(modifier = Modifier.height(18.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = state.rememberPassword,
                    onCheckedChange = { viewModel.state = state.copy(rememberPassword = it) })
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Remember password",
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    color = colorScheme.onSurfaceVariant
                )
            }
            Text(
                text = "Forgot Password?",
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                color = colorScheme.primary,
                modifier = Modifier.clickable {
                    navController.navigate(NavDestinations.ForgotPassword)
                }
            )
        }
        Spacer(modifier = Modifier.height(180.dp))
        MaxWidthButton(
            text = "Log in",
            onClick = {
                viewModel.signIn(navController)
            },
            enabled = state.email.isNotEmpty() && state.password.isNotEmpty() && state.email.isEmailValid()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = colorScheme.onSurfaceVariant)) {
                    append("Already have an account?")
                }
                withStyle(SpanStyle(color = colorScheme.primary)) {
                    append("Sign Up")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(NavDestinations.SignUp)
                },
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(18.dp))
        GoogleButton(text = "or sign in using") {

        }
    }
}