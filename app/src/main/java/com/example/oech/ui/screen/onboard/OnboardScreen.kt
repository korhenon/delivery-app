package com.example.oech.ui.screen.onboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.oech.data.utils.NavDestinations
import com.example.oech.ui.widgets.MaxWidthButton

@Composable
fun OnboardScreen(navController: NavHostController, viewModel: OnboardViewModel = hiltViewModel()) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(460.dp), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = viewModel.page.image),
                    contentDescription = "",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
            }
            Text(
                text = viewModel.page.title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = colorScheme.primary,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = viewModel.page.text,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = colorScheme.onBackground,
                fontSize = 16.sp
            )
        }
        Column {
            if (!viewModel.isLast) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    OutlinedButton(
                        onClick = {
                            viewModel.skip()
                            navController.navigate(NavDestinations.SignUp)
                        },
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = colorScheme.primary),
                        border = BorderStroke(1.dp, colorScheme.primary),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        Text(
                            text = "Skip",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(horizontal = 18.dp, vertical = 10.dp)
                        )
                    }
                    Button(
                        onClick = { viewModel.next() },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = colorScheme.background,
                            containerColor = colorScheme.primary
                        ),
                        shape = RoundedCornerShape(5.dp)
                    ) {
                        Text(
                            text = "Next",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(horizontal = 18.dp, vertical = 10.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(100.dp))
            } else {
                MaxWidthButton(text = "Sign Up", onClick = {
                    viewModel.skip()
                    navController.navigate(NavDestinations.SignUp)
                })
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
                        .height(80.dp)
                        .clickable {
                            navController.navigate(NavDestinations.SignIn)
                        },
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp
                )
            }
        }
    }
}