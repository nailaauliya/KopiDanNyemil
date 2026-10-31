package lat.pam.kopidannyemil.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import lat.pam.kopidannyemil.components.CoffeeButton
import lat.pam.kopidannyemil.components.CoffeeTextField
import lat.pam.kopidannyemil.design.*

@Composable
fun AlamatScreen(
    name: String,
    totalItems: Int,
    totalPrice: Int,
    onBack: () -> Unit,
    onConfirm: (String, String, String, String) -> Unit
) {
    var recipient by remember(name) {
        mutableStateOf(name)
    }

    var phone by remember {
        mutableStateOf("")
    }

    var address by remember {
        mutableStateOf("")
    }

    var notes by remember {
        mutableStateOf("")
    }

    var error by remember {
        mutableStateOf("")
    }

    val rupiah = "Rp " +
            "%,d".format(totalPrice).replace(',', '.')

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp)
    ) {

        Spacer(modifier = Modifier.height(4.dp))

        // HEADER

        Row(
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
                text = "Alamat Pengiriman",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = Espresso
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Hampir selesai!",
            fontSize = 29.sp,
            fontWeight = FontWeight.Bold,
            color = Espresso
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Lengkapi informasi pengiriman agar " +
                    "pesanan kopi dan camilanmu sampai dengan tepat.",
            fontSize = 14.sp,
            lineHeight = 22.sp,
            color = MutedBrown
        )

        Spacer(modifier = Modifier.height(28.dp))

        // NAMA PENERIMA

        CoffeeTextField(
            label = "Nama Penerima",
            placeholder = "Masukkan nama penerima",
            value = recipient,
            onValueChange = {
                recipient = it
                error = ""
            }
        )

        Spacer(modifier = Modifier.height(18.dp))

        // ========================================
        // NOMOR HANDPHONE
        // ========================================

        Text(
            text = "Nomor Handphone",
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = Espresso
        )

        Spacer(modifier = Modifier.height(9.dp))

        OutlinedTextField(
            value = phone,
            onValueChange = {
                phone = it.filter { char -> char.isDigit() }
                    .take(15)
                error = ""
            },
            placeholder = {
                Text(
                    text = "Contoh: 081234567890",
                    fontSize = 13.sp
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            ),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(13.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Espresso,
                unfocusedBorderColor = Color(0xFFDCCFC2),
                focusedContainerColor = FieldColor,
                unfocusedContainerColor = FieldColor
            )
        )

        Spacer(modifier = Modifier.height(18.dp))

        // ALAMAT LENGKAP

        Text(
            text = "Alamat Lengkap",
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = Espresso
        )

        Spacer(modifier = Modifier.height(9.dp))

        OutlinedTextField(
            value = address,
            onValueChange = {
                address = it
                error = ""
            },
            placeholder = {
                Text(
                    text = "Jalan, nomor rumah, kecamatan, kota",
                    fontSize = 13.sp
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 105.dp),
            shape = RoundedCornerShape(13.dp),
            minLines = 3,
            maxLines = 5,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Espresso,
                unfocusedBorderColor = Color(0xFFDCCFC2),
                focusedContainerColor = FieldColor,
                unfocusedContainerColor = FieldColor
            )
        )

        Spacer(modifier = Modifier.height(18.dp))

        // CATATAN TAMBAHAN

        Text(
            text = "Catatan Tambahan (Opsional)",
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = Espresso
        )

        Spacer(modifier = Modifier.height(9.dp))

        OutlinedTextField(
            value = notes,
            onValueChange = {
                notes = it
            },
            placeholder = {
                Text(
                    text = "Contoh: Rumah pagar hitam",
                    fontSize = 13.sp
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp),
            shape = RoundedCornerShape(13.dp),
            minLines = 2,
            maxLines = 4,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Espresso,
                unfocusedBorderColor = Color(0xFFDCCFC2),
                focusedContainerColor = FieldColor,
                unfocusedContainerColor = FieldColor
            )
        )

        Spacer(modifier = Modifier.height(26.dp))

        // RINGKASAN PESANAN

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(18.dp)
                )
                .padding(20.dp)
        ) {
            Text(
                text = "Ringkasan Pesanan",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Espresso
            )

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$totalItems item",
                    color = MutedBrown,
                    fontSize = 14.sp
                )

                Text(
                    text = rupiah,
                    color = Espresso,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // PESAN VALIDASI

        if (error.isNotEmpty()) {
            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = error,
                color = ErrorRed,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        // TOMBOL KONFIRMASI

        CoffeeButton(
            text = "Konfirmasi Pesanan  →",
            onClick = {
                when {
                    recipient.isBlank() ||
                            phone.isBlank() ||
                            address.isBlank() -> {
                        error = "Lengkapi semua kolom wajib."
                    }

                    phone.length < 10 ||
                            phone.length > 15 -> {
                        error = "Nomor HP harus 10–15 digit."
                    }

                    !phone.startsWith("08") -> {
                        error = "Nomor HP harus diawali 08."
                    }

                    totalItems <= 0 -> {
                        error = "Belum ada produk yang dipilih."
                    }

                    else -> {
                        onConfirm(
                            recipient.trim(),
                            phone.trim(),
                            address.trim(),
                            notes.trim()
                        )
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(30.dp))
    }
}

// PREVIEW ALAMAT PENGIRIMAN

@Preview(
    name = "07 - Alamat Pengiriman",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AlamatScreenPreview() {
    MaterialTheme {
        AlamatScreen(
            name = "Naila Aghna",
            totalItems = 2,
            totalPrice = 48000,
            onBack = {},
            onConfirm = { _, _, _, _ -> }
        )
    }
}
