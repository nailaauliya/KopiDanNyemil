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
fun RegisterScreen(
    onBack: () -> Unit,
    onLogin: () -> Unit,
    onRegisterSuccess: (String, String, String) -> Unit
) {
    var fullName by remember {
        mutableStateOf("")
    }

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var errorMessage by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 26.dp)
    ) {

        Spacer(modifier = Modifier.height(4.dp))

        // Header
        AuthHeader(
            title = "Buat Akun Baru",
            subtitle = "Isi data berikut untuk bergabung dan " +
                    "mulai menikmati kopi favoritmu.",
            onBack = onBack
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Nama lengkap
        CoffeeTextField(
            label = "Nama Lengkap",
            placeholder = "Masukkan nama lengkap",
            value = fullName,
            onValueChange = {
                fullName = it
                errorMessage = ""
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Username
        CoffeeTextField(
            label = "Username",
            placeholder = "Buat username",
            value = username,
            onValueChange = {
                username = it
                errorMessage = ""
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Password
        CoffeeTextField(
            label = "Password",
            placeholder = "Buat password minimal 6 karakter",
            value = password,
            onValueChange = {
                password = it
                errorMessage = ""
            },
            isPassword = true
        )

        // Pesan validasi
        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = errorMessage,
                color = ErrorRed,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Tombol daftar
        CoffeeButton(
            text = "Daftar Sekarang  →",
            onClick = {
                when {
                    fullName.isBlank() ||
                            username.isBlank() ||
                            password.isBlank() -> {
                        errorMessage = "Semua kolom wajib diisi."
                    }

                    password.length < 6 -> {
                        errorMessage = "Password minimal 6 karakter."
                    }

                    else -> {
                        onRegisterSuccess(
                            fullName.trim(),
                            username.trim(),
                            password
                        )
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Masuk ke akun
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Sudah punya akun?",
                fontSize = 13.sp,
                color = MutedBrown
            )

            TextButton(onClick = onLogin) {
                Text(
                    text = "Masuk",
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
    name = "04 - Register",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun RegisterScreenPreview() {
    MaterialTheme {
        RegisterScreen(
            onBack = {},
            onLogin = {},
            onRegisterSuccess = { _, _, _ -> }
        )
    }
}
