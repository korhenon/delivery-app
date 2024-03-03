package com.example.oech.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.oech.data.utils.NavDestinations
import com.example.oech.ui.screen.addpaymentmethod.AddPaymentMethodScreen
import com.example.oech.ui.screen.forgotpassword.ForgotPasswordScreen
import com.example.oech.ui.screen.home.HomeScreen
import com.example.oech.ui.screen.newpassword.NewPasswordScreen
import com.example.oech.ui.screen.newpassword.NewPasswordViewModel
import com.example.oech.ui.screen.notification.NotificationScreen
import com.example.oech.ui.screen.onboard.OnboardScreen
import com.example.oech.ui.screen.otpverification.OTPVerificaionScreen
import com.example.oech.ui.screen.otpverification.OTPVerificationViewModel
import com.example.oech.ui.screen.profile.ProfileScreen
import com.example.oech.ui.screen.receipt.ReceiptScreen
import com.example.oech.ui.screen.receipt.ReceiptViewModel
import com.example.oech.ui.screen.sendpackage.SendPackageScreen
import com.example.oech.ui.screen.signin.SignInScreen
import com.example.oech.ui.screen.signup.SignUpScreen
import com.example.oech.ui.screen.splash.SplashScreen
import com.example.oech.ui.screen.transactionsuccessful.TransactionSuccessfulScreen
import com.example.oech.ui.screen.transactionsuccessful.TransactionSuccessfulViewModel
import com.example.oech.ui.widgets.CustomBottomNavigation

@Composable
fun NavGraph(
    otpVerificationViewModel: OTPVerificationViewModel = hiltViewModel(),
    newPasswordViewModel: NewPasswordViewModel = hiltViewModel(),
    receiptViewModel: ReceiptViewModel = hiltViewModel(),
    transactionSuccessfulViewModel: TransactionSuccessfulViewModel = hiltViewModel()
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
            CustomBottomNavigation(NavDestinations.Home, navController) {
                HomeScreen(navController)
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
        composable(NavDestinations.Profile) {
            CustomBottomNavigation(NavDestinations.Profile, navController, true) {
                ProfileScreen(navController)
            }
        }
        composable(NavDestinations.AddPaymentMethod) {
            AddPaymentMethodScreen(navController)
        }
        composable(NavDestinations.Notifications) {
            NotificationScreen(navController)
        }
        composable(NavDestinations.SendPackage) {
            SendPackageScreen(navController, receiptViewModel)
        }
        composable(NavDestinations.Receipt) {
            ReceiptScreen(navController, receiptViewModel, transactionSuccessfulViewModel)
        }
        composable(NavDestinations.TransactionSuccessful) {
            TransactionSuccessfulScreen(navController, transactionSuccessfulViewModel)
        }
        composable(NavDestinations.Track) {

        }
    }
}