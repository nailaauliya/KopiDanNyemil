package lat.pam.kopidannyemil.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import lat.pam.kopidannyemil.components.AuthHeader
import lat.pam.kopidannyemil.components.CoffeeButton
import lat.pam.kopidannyemil.components.CoffeeTextField
import lat.pam.kopidannyemil.design.Cream
import lat.pam.kopidannyemil.design.Espresso
import lat.pam.kopidannyemil.design.MutedBrown
import lat.pam.kopidannyemil.design.ErrorRed

@Composable
fun LoginScreen(
    registeredUsername: String,
    registeredPassword: String,
    onBack: () -> Unit,
    onRegister: () -> Unit,
    onLoginSuccess: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 26.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        AuthHeader(
            title = "Masuk ke\nAkunmu",
            subtitle = "Selamat datang kembali! Masuk untuk " +
                    "melanjutkan pesanan favoritmu.",
            onBack = onBack
        )

        Spacer(modifier = Modifier.height(38.dp))

        CoffeeTextField(
            label = "Username",
            placeholder = "Masukkan username",
            value = username,
            onValueChange = {
                username = it
                errorMessage = ""
            }
        )

        Spacer(modifier = Modifier.height(22.dp))

        CoffeeTextField(
            label = "Password",
            placeholder = "Masukkan password",
            value = password,
            onValueChange = {
                password = it
                errorMessage = ""
            },
            isPassword = true
        )

        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = errorMessage,
                color = ErrorRed,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(34.dp))

        CoffeeButton(
            text = "Masuk  →",
            onClick = {
                when {
                    username.isBlank() || password.isBlank() -> {
                        errorMessage = "Username dan password wajib diisi."
                    }

                    registeredUsername.isBlank() -> {
                        errorMessage = "Belum ada akun. Silakan daftar dulu."
                    }

                    username.trim() == registeredUsername &&
                            password == registeredPassword -> {
                        onLoginSuccess()
                    }

                    else -> {
                        errorMessage = "Username atau password salah."
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(25.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Belum punya akun?",
                fontSize = 13.sp,
                color = MutedBrown
            )

            TextButton(onClick = onRegister) {
                Text(
                    text = "Daftar sekarang",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Espresso
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Preview(
    name = "03 - Login",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LoginScreenPreview() {
    MaterialTheme {
        LoginScreen(
            registeredUsername = "",
            registeredPassword = "",
            onBack = {},
            onRegister = {},
            onLoginSuccess = {}
        )
    }
}
