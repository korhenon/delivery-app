package com.example.oech.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.oech.data.utils.NavDestinations
import com.example.oech.ui.screen.forgotpassword.ForgotPasswordScreen
import com.example.oech.ui.screen.newpassword.NewPasswordScreen
import com.example.oech.ui.screen.newpassword.NewPasswordViewModel
import com.example.oech.ui.screen.onboard.OnboardScreen
import com.example.oech.ui.screen.otpverification.OTPVerificaionScreen
import com.example.oech.ui.screen.otpverification.OTPVerificationViewModel
import com.example.oech.ui.screen.signin.SignInScreen
import com.example.oech.ui.screen.signup.SignUpScreen
import com.example.oech.ui.screen.splash.SplashScreen

@Composable
fun NavGraph(
    otpVerificationViewModel: OTPVerificationViewModel = hiltViewModel(),
    newPasswordViewModel: NewPasswordViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavDestinations.Splash) {
        composable(NavDestinations.Splash) {
            SplashScreen(navController)
        }
        composable(NavDestinations.Onboard) {
            OnboardScreen(navController)
        }
        composable(NavDestinations.Home) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Home", color = Color.Black, fontSize = 24.sp)
            }
        }
        composable(NavDestinations.SignUp) {
            SignUpScreen(navController)
        }
        composable(NavDestinations.SignIn) {
            SignInScreen(navController)
        }
        composable(NavDestinations.ForgotPassword) {
            ForgotPasswordScreen(navController, otpVerificationViewModel)
        }
        composable(NavDestinations.OTPVerification) {
            OTPVerificaionScreen(navController, otpVerificationViewModel, newPasswordViewModel)
        }
        composable(NavDestinations.NewPassword) {
            NewPasswordScreen(navController, newPasswordViewModel)
        }
    }
}