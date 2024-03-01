package com.example.oech.ui.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech.R

@Composable
fun FieldWithLabel(
    label: String,
    placeholder: String,
    value: String,
    onChange: (String) -> Unit,
    isError: Boolean = false,
) {
    Text(
        text = label,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = colorScheme.onSurfaceVariant
    )
    Spacer(modifier = Modifier.height(8.dp))
    OutlinedTextField(
        value = value, onValueChange = { onChange(it) },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = colorScheme.onSurfaceVariant,
            focusedBorderColor = colorScheme.onSurfaceVariant,
            errorBorderColor = colorScheme.error
        ),
        isError = isError,
        placeholder = {
            Text(
                text = placeholder,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = colorScheme.onSurface
            )
        },
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(color = Color.Black)
    )
}

@Composable
fun PasswordField(
    label: String,
    value: String,
    onChange: (String) -> Unit,
) {
    var hide by remember {
        mutableStateOf(true)
    }
    Text(
        text = label,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = colorScheme.onSurfaceVariant
    )
    Spacer(modifier = Modifier.height(8.dp))
    OutlinedTextField(
        value = value, onValueChange = { onChange(it) },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = colorScheme.onSurfaceVariant,
            focusedBorderColor = colorScheme.onSurfaceVariant,
            errorBorderColor = colorScheme.error
        ),
        placeholder = {
            Text(
                text = "**********",
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = colorScheme.onSurface
            )
        },
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = if (hide) PasswordVisualTransformation('*') else VisualTransformation.None,
        trailingIcon = {
            IconButton(onClick = { hide = !hide }) {
                Icon(
                    painter = painterResource(id = if (hide) R.drawable.baseline_visibility_24 else R.drawable.baseline_visibility_off_24),
                    contentDescription = ""
                )
            }
        },
        textStyle = TextStyle(color = Color.Black)
    )
}