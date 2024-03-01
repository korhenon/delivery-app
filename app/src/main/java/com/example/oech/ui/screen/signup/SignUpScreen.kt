package com.example.oech.ui.screen.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme.colorScheme
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
import com.example.oech.ui.widgets.FieldWithLabel
import com.example.oech.ui.widgets.GoogleButton
import com.example.oech.ui.widgets.MaxWidthButton
import com.example.oech.ui.widgets.PasswordField

@Composable
fun SignUpScreen(navController: NavHostController, viewModel: SignUpViewModel = hiltViewModel()) {
    val state = viewModel.state
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Create an account",
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            color = colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Complete the sign up process to get started",
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(30.dp))
        FieldWithLabel(
            label = "Full name",
            placeholder = "Ivanov Ivan",
            value = state.name,
            onChange = {
                viewModel.state = state.copy(name = it)
            })
        Spacer(modifier = Modifier.height(24.dp))
        FieldWithLabel(
            label = "Phone Number",
            placeholder = "+7(999)999-99-99",
            value = state.phone,
            onChange = {
                viewModel.state = state.copy(phone = it)
            })
        Spacer(modifier = Modifier.height(24.dp))
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
        PasswordField(label = "Password",
            value = state.password,
            onChange = {
                viewModel.state = state.copy(password = it)
            })
        Spacer(modifier = Modifier.height(24.dp))
        PasswordField(label = "Confirm Password",
            value = state.passwordConfirmation,
            onChange = {
                viewModel.state = state.copy(passwordConfirmation = it)
            })
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            Checkbox(
                checked = state.privacyPolicy,
                onCheckedChange = { viewModel.state = state.copy(privacyPolicy = it) })
            Text(text = buildAnnotatedString {
                withStyle(SpanStyle(color = colorScheme.onSurfaceVariant)) {
                    append("By ticking this box, you agree to our ")
                }
                withStyle(SpanStyle(color = colorScheme.surfaceTint)) {
                    append("Terms and conditions and private policy")
                }
            }, fontSize = 12.sp)
        }
        Spacer(modifier = Modifier.height(60.dp))
        MaxWidthButton(text = "Sign Up", onClick = {
            viewModel.signUp(navController)
        }, enabled = viewModel.canSignUp)
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = colorScheme.onSurfaceVariant)) {
                    append("Already have an account?")
                }
                withStyle(SpanStyle(color = colorScheme.primary)) {
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
        Spacer(modifier = Modifier.height(18.dp))
        GoogleButton(text = "or sign in using") {

        }
    }
}