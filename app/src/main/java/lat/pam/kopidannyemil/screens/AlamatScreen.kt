package lat.pam.kopidannyemil.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import lat.pam.kopidannyemil.design.*

private fun formatHargaAlamat(harga: Int): String {
    return "Rp " + "%,d".format(harga).replace(',', '.')
}

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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .statusBarsPadding()
            .imePadding()
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
            IconButton(
                onClick = onBack,
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Kembali",
                    tint = Espresso,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(Modifier.width(8.dp))

            Text(
                text = "Alamat Pengiriman",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Espresso
            )
        }

        HorizontalDivider(
            color = Color(0xFFEAE0D5)
        )

        // KONTEN YANG BISA DI-SCROLL
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(
                    horizontal = 24.dp,
                    vertical = 16.dp
                )
        ) {
            Text(
                text = "Hampir selesai!",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = Espresso
            )

            Spacer(Modifier.height(7.dp))

            Text(
                text = "Lengkapi informasi pengiriman agar pesananmu bisa diproses.",
                fontSize = 13.sp,
                lineHeight = 20.sp,
                color = MutedBrown
            )

            Spacer(Modifier.height(24.dp))

            AlamatInputField(
                label = "Nama Penerima",
                value = recipient,
                onValueChange = {
                    recipient = it
                    error = ""
                },
                placeholder = "Masukkan nama penerima"
            )

            Spacer(Modifier.height(16.dp))

            AlamatInputField(
                label = "Nomor HP",
                value = phone,
                onValueChange = {
                    phone = it
                    error = ""
                },
                placeholder = "Contoh: 081234567890",
                keyboardType = KeyboardType.Phone
            )

            Spacer(Modifier.height(16.dp))

            AlamatInputField(
                label = "Alamat Lengkap",
                value = address,
                onValueChange = {
                    address = it
                    error = ""
                },
                placeholder = "Masukkan alamat pengiriman",
                singleLine = false,
                minLines = 3
            )

            Spacer(Modifier.height(16.dp))

            AlamatInputField(
                label = "Catatan (Opsional)",
                value = notes,
                onValueChange = {
                    notes = it
                },
                placeholder = "Contoh: Rumah pagar hitam",
                singleLine = false,
                minLines = 2
            )

            Spacer(Modifier.height(24.dp))

            // RINGKASAN PESANAN
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {
                    Text(
                        text = "Ringkasan Pesanan",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = Espresso
                    )

                    Spacer(Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Jumlah Produk",
                            fontSize = 13.sp,
                            color = MutedBrown
                        )

                        Text(
                            text = "$totalItems item",
                            fontSize = 13.sp,
                            color = Espresso
                        )
                    }

                    Spacer(Modifier.height(14.dp))

                    HorizontalDivider(
                        color = Color(0xFFEDE4DA)
                    )

                    Spacer(Modifier.height(14.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Total Harga",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Espresso
                        )

                        Text(
                            text = formatHargaAlamat(totalPrice),
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = Espresso
                        )
                    }
                }
            }

            Spacer(Modifier.height(16.dp))
        }

        // TOMBOL KONFIRMASI TETAP DI BAWAH
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .navigationBarsPadding()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
        ) {
            if (error.isNotEmpty()) {
                Text(
                    text = error,
                    color = ErrorRed,
                    fontSize = 12.sp
                )

                Spacer(Modifier.height(8.dp))
            }

            CoffeeButton(
                text = "Konfirmasi Pesanan →",
                onClick = {
                    val cleanName = recipient.trim()
                    val cleanPhone = phone.trim()
                    val cleanAddress = address.trim()

                    error = when {
                        cleanName.isBlank() ->
                            "Nama penerima wajib diisi."

                        cleanPhone.isBlank() ->
                            "Nomor HP wajib diisi."

                        !cleanPhone.all { it.isDigit() } ||
                                !cleanPhone.startsWith("08") ||
                                cleanPhone.length !in 10..15 ->
                            "Nomor HP harus 10–15 digit dan diawali 08."

                        cleanAddress.isBlank() ->
                            "Alamat lengkap wajib diisi."

                        totalItems <= 0 ->
                            "Keranjang masih kosong."

                        else -> ""
                    }

                    if (error.isEmpty()) {
                        onConfirm(
                            cleanName,
                            cleanPhone,
                            cleanAddress,
                            notes.trim()
                        )
                    }
                }
            )
        }
    }
}

// KOMPONEN INPUT ALAMAT
@Composable
private fun AlamatInputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    singleLine: Boolean = true,
    minLines: Int = 1
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = Espresso
        )

        Spacer(Modifier.height(7.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = placeholder,
                    fontSize = 13.sp
                )
            },
            singleLine = singleLine,
            minLines = minLines,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Espresso,
                unfocusedBorderColor = Color(0xFFE6DACE),
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )
    }
}

// PREVIEW
@Preview(
    name = "Alamat Pengiriman",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AlamatScreenPreview() {
    MaterialTheme {
        AlamatScreen(
            name = "Naila Aghna",
            totalItems = 3,
            totalPrice = 75000,
            onBack = {},
            onConfirm = { _, _, _, _ -> }
        )
    }
}
