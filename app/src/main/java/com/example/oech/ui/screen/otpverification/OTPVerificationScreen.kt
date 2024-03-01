package com.example.oech.ui.screen.otpverification

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.oech.ui.screen.newpassword.NewPasswordViewModel
import com.example.oech.ui.widgets.MaxWidthButton
import kotlinx.coroutines.delay

@Composable
fun OTPVerificaionScreen(
    navController: NavHostController,
    viewModel: OTPVerificationViewModel,
    newPasswordViewModel: NewPasswordViewModel
) {
    var timer by remember { mutableIntStateOf(60) }
    val focuses = listOf(
        FocusRequester(),
        FocusRequester(),
        FocusRequester(),
        FocusRequester(),
        FocusRequester()
    )
    LaunchedEffect(key1 = timer) {
        if (timer > 0) {
            delay(1_000)
            timer -= 1
        }
    }
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(110.dp))
        Text(
            text = "OTP Verification",
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            color = colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Enter the 6 digit numbers sent to your email",
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(50.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            for ((i, value) in viewModel.code.withIndex()) {
                OutlinedTextField(
                    value = value,
                    onValueChange = {
                        if (it.isEmpty() || it.length == 1) {
                            val copy = viewModel.code.toMutableList()
                            copy[i] = it
                            viewModel.code = copy
                            if (it.length == 1 && i < 5) {
                                focuses[i].requestFocus()
                            }
                        }
                    },
                    modifier = if (i != 0) Modifier
                        .size(50.dp)
                        .focusRequester(focuses[i - 1]) else Modifier.size(50.dp),
                    textStyle = TextStyle(
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    ),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = if (value.isNotEmpty()) colorScheme.primary else colorScheme.onSurfaceVariant,
                        focusedBorderColor = if (value.isNotEmpty()) colorScheme.primary else colorScheme.onSurfaceVariant,
                        errorBorderColor = colorScheme.error
                    ),
                    isError = viewModel.isError
                )
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = buildAnnotatedString {
                if (timer == 0) {
                    withStyle(SpanStyle(color = colorScheme.onSurfaceVariant)) {
                        append("If you didn’t receive code, ")
                    }
                    withStyle(SpanStyle(color = colorScheme.primary)) {
                        append("resend")
                    }
                } else {
                    withStyle(SpanStyle(color = colorScheme.onSurfaceVariant)) {
                        append("If you didn’t receive code, resend after ${if (timer == 60) "1:00" else "0:$timer"}")
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    if (timer == 0) {
                        timer = 60
                    }
                },
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(80.dp))
        MaxWidthButton(text = "Set New Password", onClick = {
            viewModel.checkCode(navController, newPasswordViewModel)
        }, enabled = viewModel.isButtonEnabled)
    }
}