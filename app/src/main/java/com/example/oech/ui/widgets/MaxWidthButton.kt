package com.example.oech.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MaxWidthButton(text: String, onClick: () -> Unit, enabled: Boolean = true) {
    Button(
        onClick = { onClick() },
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            contentColor = colorScheme.background,
            containerColor = colorScheme.primary,
            disabledContainerColor = colorScheme.onSurfaceVariant,
            disabledContentColor = colorScheme.background
        ),
        shape = RoundedCornerShape(5.dp),
        enabled = enabled
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            modifier = Modifier.padding(vertical = 10.dp)
        )
    }
}