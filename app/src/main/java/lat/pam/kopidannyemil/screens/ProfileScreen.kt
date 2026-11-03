package lat.pam.kopidannyemil.screens

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Patterns
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lat.pam.kopidannyemil.components.CoffeeButton
import lat.pam.kopidannyemil.design.*

@Composable
fun ProfileScreen(
    name: String,
    username: String,
    photoUri: Uri?,
    onPhotoChange: (Uri) -> Unit,
    onSave: (String) -> Unit,
    onBack: () -> Unit,
    onLogout: () -> Unit
) {
    val context = LocalContext.current

    val preferences = remember {
        context.getSharedPreferences(
            "kopi_dan_nyemil_profile",
            Context.MODE_PRIVATE
        )
    }

    val accountKey = username.ifBlank { "default" }

    var editedName by remember(name) {
        mutableStateOf(name)
    }

    var email by remember(accountKey) {
        mutableStateOf(
            preferences.getString(
                "${accountKey}_email",
                ""
            ) ?: ""
        )
    }

    var phone by remember(accountKey) {
        mutableStateOf(
            preferences.getString(
                "${accountKey}_phone",
                ""
            ) ?: ""
        )
    }

    var message by remember {
        mutableStateOf("")
    }

    var isError by remember {
        mutableStateOf(false)
    }

    // PILIH FOTO DARI GALERI
    val photoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let {
            onPhotoChange(it)
        }
    }

    // TAMPILKAN FOTO PROFIL
    val photoBitmap = remember(photoUri) {
        photoUri?.let { uri ->
            try {
                context.contentResolver
                    .openInputStream(uri)
                    ?.use { stream ->
                        BitmapFactory.decodeStream(stream)
                    }
                    ?.asImageBitmap()
            } catch (e: Exception) {
                null
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .statusBarsPadding()
    ) {

        // HEADER
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 12.dp,
                    end = 20.dp,
                    top = 4.dp,
                    bottom = 4.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Kembali",
                    tint = Espresso
                )
            }

            Spacer(Modifier.width(8.dp))

            Text(
                text = "Profil Saya",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Espresso
            )
        }

        HorizontalDivider(
            color = Color(0xFFEAE0D5)
        )

        // KONTEN PROFILE
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .imePadding()
                .padding(
                    horizontal = 24.dp,
                    vertical = 12.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // FOTO PROFIL
            Box(
                modifier = Modifier.size(106.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(96.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFF0E5D8))
                        .clickable {
                            photoPicker.launch("image/*")
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if (photoBitmap != null) {
                        Image(
                            bitmap = photoBitmap,
                            contentDescription = "Foto profil",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        Text(
                            text = name
                                .trim()
                                .split(" ")
                                .filter { it.isNotBlank() }
                                .take(2)
                                .mapNotNull { it.firstOrNull() }
                                .joinToString("")
                                .uppercase()
                                .ifEmpty { "U" },
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Espresso
                        )
                    }
                }

                // IKON KAMERA
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .size(33.dp)
                        .clip(CircleShape)
                        .background(Espresso)
                        .clickable {
                            photoPicker.launch("image/*")
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.CameraAlt,
                        contentDescription = "Ganti foto profil",
                        tint = Color.White,
                        modifier = Modifier.size(17.dp)
                    )
                }
            }

            Spacer(Modifier.height(5.dp))

            Text(
                text = "Ketuk foto untuk mengganti",
                fontSize = 11.sp,
                color = MutedBrown
            )

            Spacer(Modifier.height(9.dp))

            Text(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Espresso,
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(3.dp))

            Text(
                text = "@$username",
                fontSize = 12.sp,
                color = MutedBrown
            )

            Spacer(Modifier.height(17.dp))

            // LANGSUNG INFORMASI PRIBADI
            HorizontalDivider(
                color = Color(0xFFE8DDD1)
            )

            Spacer(Modifier.height(15.dp))

            Text(
                text = "Informasi Pribadi",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Espresso
            )

            Spacer(Modifier.height(13.dp))

            // NAMA LENGKAP
            ProfileCompactField(
                label = "Nama Lengkap",
                value = editedName,
                onValueChange = {
                    editedName = it
                    message = ""
                },
                placeholder = "Masukkan nama lengkap",
                leadingIcon = {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = null,
                        tint = MutedBrown,
                        modifier = Modifier.size(19.dp)
                    )
                }
            )

            Spacer(Modifier.height(12.dp))

            // USERNAME
            ProfileCompactField(
                label = "Username",
                value = username,
                onValueChange = {},
                placeholder = "Username",
                enabled = false,
                leadingIcon = {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = null,
                        tint = MutedBrown,
                        modifier = Modifier.size(19.dp)
                    )
                }
            )

            Spacer(Modifier.height(12.dp))

            // EMAIL
            ProfileCompactField(
                label = "Email",
                value = email,
                onValueChange = {
                    email = it
                    message = ""
                },
                placeholder = "Masukkan alamat email",
                keyboardType = KeyboardType.Email,
                leadingIcon = {
                    Icon(
                        Icons.Filled.Email,
                        contentDescription = null,
                        tint = MutedBrown,
                        modifier = Modifier.size(19.dp)
                    )
                }
            )

            Spacer(Modifier.height(12.dp))

            // NOMOR HP
            ProfileCompactField(
                label = "Nomor HP",
                value = phone,
                onValueChange = {
                    phone = it
                    message = ""
                },
                placeholder = "Contoh: 081234567890",
                keyboardType = KeyboardType.Phone,
                leadingIcon = {
                    Icon(
                        Icons.Filled.Phone,
                        contentDescription = null,
                        tint = MutedBrown,
                        modifier = Modifier.size(19.dp)
                    )
                }
            )

            Spacer(Modifier.height(19.dp))

            // SIMPAN PERUBAHAN
            CoffeeButton(
                text = "Simpan Perubahan",
                onClick = {
                    val cleanName = editedName.trim()
                    val cleanEmail = email.trim()
                    val cleanPhone = phone.trim()

                    when {
                        cleanName.isBlank() -> {
                            isError = true
                            message = "Nama lengkap tidak boleh kosong."
                        }

                        cleanEmail.isNotEmpty() &&
                                !Patterns.EMAIL_ADDRESS
                                    .matcher(cleanEmail)
                                    .matches() -> {
                            isError = true
                            message = "Format email tidak valid."
                        }

                        cleanPhone.isNotEmpty() &&
                                (
                                        !cleanPhone.all { it.isDigit() } ||
                                                !cleanPhone.startsWith("08") ||
                                                cleanPhone.length !in 10..15
                                        ) -> {
                            isError = true
                            message = "Nomor HP harus 10–15 digit dan diawali 08."
                        }

                        else -> {
                            preferences.edit()
                                .putString(
                                    "${accountKey}_email",
                                    cleanEmail
                                )
                                .putString(
                                    "${accountKey}_phone",
                                    cleanPhone
                                )
                                .apply()

                            email = cleanEmail
                            phone = cleanPhone

                            onSave(cleanName)

                            isError = false
                            message = "Profil berhasil diperbarui."
                        }
                    }
                }
            )

            if (message.isNotEmpty()) {
                Spacer(Modifier.height(8.dp))

                Text(
                    text = message,
                    fontSize = 12.sp,
                    color = if (isError) {
                        ErrorRed
                    } else {
                        Color(0xFF51815B)
                    },
                    textAlign = TextAlign.Center
                )
            }

            Spacer(Modifier.height(9.dp))

            // LOGOUT
            TextButton(onClick = onLogout) {
                Text(
                    text = "Keluar dari Akun",
                    fontSize = 13.sp,
                    color = ErrorRed,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(Modifier.height(8.dp))
        }
    }
}

// INPUT PROFIL LEBIH COMPACT
@Composable
private fun ProfileCompactField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    enabled: Boolean = true,
    keyboardType: KeyboardType = KeyboardType.Text,
    leadingIcon: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Espresso
        )

        Spacer(Modifier.height(5.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            enabled = enabled,
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(
                fontSize = 13.sp
            ),
            placeholder = {
                Text(
                    text = placeholder,
                    fontSize = 12.sp
                )
            },
            leadingIcon = leadingIcon,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            shape = RoundedCornerShape(13.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Espresso,
                unfocusedBorderColor = Color(0xFFE6DACE),
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color(0xFFF1ECE6),
                disabledBorderColor = Color(0xFFE6DACE),
                disabledTextColor = MutedBrown
            )
        )
    }
}

@Preview(
    name = "Profile Compact",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ProfileScreenPreview() {
    MaterialTheme {
        ProfileScreen(
            name = "Naila Aghna Auliya",
            username = "naila.aghna",
            photoUri = null,
            onPhotoChange = {},
            onSave = {},
            onBack = {},
            onLogout = {}
        )
    }
}
