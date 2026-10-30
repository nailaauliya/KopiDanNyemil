package lat.pam.kopidannyemil.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import lat.pam.kopidannyemil.design.Espresso
import lat.pam.kopidannyemil.design.MutedBrown
import lat.pam.kopidannyemil.design.FieldColor

@Composable
fun CoffeeTextField(
    label: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false
) {
    var passwordVisible by remember {
        mutableStateOf(false)
    }

    Column {
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = Espresso
        )

        Spacer(modifier = Modifier.height(9.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = placeholder,
                    fontSize = 13.sp,
                    color = MutedBrown
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(13.dp),
            visualTransformation = if (
                isPassword && !passwordVisible
            ) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = if (isPassword) {
                    KeyboardType.Password
                } else {
                    KeyboardType.Text
                }
            ),
            trailingIcon = {
                if (isPassword) {
                    TextButton(
                        onClick = {
                            passwordVisible = !passwordVisible
                        }
                    ) {
                        Text(
                            text = if (passwordVisible) "Tutup" else "Lihat",
                            color = Espresso,
                            fontSize = 12.sp
                        )
                    }
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Espresso,
                unfocusedBorderColor = Color(0xFFDCCFC2),
                focusedContainerColor = FieldColor,
                unfocusedContainerColor = FieldColor,
                cursorColor = Espresso,
                focusedTextColor = Espresso,
                unfocusedTextColor = Espresso
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CoffeeTextFieldPreview() {
    var username by remember { mutableStateOf("") }
    CoffeeTextField(
        label = "Username",
        placeholder = "Masukkan username",
        value = username,
        onValueChange = { username = it }
    )
}
