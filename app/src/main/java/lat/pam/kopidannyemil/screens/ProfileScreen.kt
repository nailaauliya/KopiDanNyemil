package lat.pam.kopidannyemil.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.graphics.BitmapFactory

import lat.pam.kopidannyemil.components.CoffeeButton
import lat.pam.kopidannyemil.components.CoffeeTextField
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

    var editedName by remember(name) {
        mutableStateOf(name)
    }

    var message by remember {
        mutableStateOf("")
    }

    // BUKA GALERI MENGGUNAKAN PHOTO PICKER
    val photoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        if (uri != null) {
            onPhotoChange(uri)
        }
    }

    // MEMBACA FOTO YANG DIPILIH
    val photoBitmap = remember(photoUri) {
        photoUri?.let { uri ->
            try {
                context.contentResolver.openInputStream(uri)?.use {
                    BitmapFactory.decodeStream(it)
                }?.asImageBitmap()
            } catch (e: Exception) {
                null
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 26.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        // HEADER
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Text(
                    text = "←",
                    fontSize = 26.sp,
                    color = Espresso
                )
            }

            Text(
                text = "Profil Saya",
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Espresso
            )

            Spacer(modifier = Modifier.width(48.dp))
        }

        Spacer(modifier = Modifier.height(35.dp))

        // FOTO PROFIL + TOMBOL KAMERA
        Box(
            modifier = Modifier.size(124.dp),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .size(112.dp)
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
                        contentDescription = "Foto profil pengguna",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    // AVATAR DEFAULT SEBELUM MEMILIH FOTO
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
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold,
                        color = Espresso
                    )
                }
            }

            // IKON KAMERA
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(37.dp)
                    .clip(CircleShape)
                    .background(Espresso)
                    .clickable {
                        photoPicker.launch("image/*")
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "📷",
                    fontSize = 17.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Ketuk foto untuk mengganti",
            fontSize = 12.sp,
            color = MutedBrown
        )

        Spacer(modifier = Modifier.height(17.dp))

        Text(
            text = name,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            color = Espresso,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "@$username",
            fontSize = 13.sp,
            color = MutedBrown
        )

        Spacer(modifier = Modifier.height(30.dp))

        HorizontalDivider(
            color = Color(0xFFE8DDD1)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Informasi Profil",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Espresso
        )

        Spacer(modifier = Modifier.height(18.dp))

        CoffeeTextField(
            label = "Nama Lengkap",
            placeholder = "Masukkan nama lengkap",
            value = editedName,
            onValueChange = {
                editedName = it
                message = ""
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        CoffeeTextField(
            label = "Username",
            placeholder = "",
            value = username,
            onValueChange = {}
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Username tidak dapat diubah.",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 12.sp,
            color = MutedBrown
        )

        Spacer(modifier = Modifier.height(28.dp))

        CoffeeButton(
            text = "Simpan Perubahan",
            onClick = {
                if (editedName.isBlank()) {
                    message = "Nama lengkap tidak boleh kosong."
                } else {
                    onSave(editedName.trim())
                    message = "Perubahan profil berhasil disimpan."
                }
            }
        )

        if (message.isNotEmpty()) {
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = message,
                fontSize = 12.sp,
                color = if (editedName.isBlank()) {
                    ErrorRed
                } else {
                    Espresso
                }
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        TextButton(onClick = onLogout) {
            Text(
                text = "Keluar dari Akun",
                fontSize = 14.sp,
                color = ErrorRed,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Preview(
    name = "06 - Profile",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ProfileScreenPreview() {
    MaterialTheme {
        ProfileScreen(
            name = "Naila Aghna Auliya P",
            username = "naila.aghn ap".replace(" ", ""),
            photoUri = null,
            onPhotoChange = {},
            onSave = {},
            onBack = {},
            onLogout = {}
        )
    }
}
