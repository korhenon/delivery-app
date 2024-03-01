package com.example.oech.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech.R

@Composable
fun GoogleButton(text: String, onClick: () -> Unit) {
    Text(
        text = text, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center,
        fontSize = 14.sp, color = colorScheme.onSurfaceVariant
    )
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        IconButton(onClick = { onClick() }) {
            Image(
                painter = painterResource(id = R.drawable.google_icon),
                contentDescription = "",
                Modifier.size(16.dp)
            )
        }
    }
}