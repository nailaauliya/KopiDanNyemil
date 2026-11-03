package lat.pam.kopidannyemil.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lat.pam.kopidannyemil.components.CoffeeButton
import lat.pam.kopidannyemil.design.*

@Composable
fun KonfirmasiScreen(
    recipient: String,
    totalItems: Int,
    totalPrice: Int,
    onHome: () -> Unit
) {
    val totalRupiah = "Rp " +
            "%,d".format(totalPrice).replace(',', '.')

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .statusBarsPadding()
    ) {

        // KONTEN UTAMA
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 30.dp,
                    bottom = 24.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(12.dp))

            // IKON BERHASIL
            Box(
                modifier = Modifier
                    .size(126.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE5F0DF)),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(94.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF649568)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = "Pesanan berhasil",
                        tint = Color.White,
                        modifier = Modifier.size(55.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(26.dp))

            // JUDUL
            Text(
                text = "Pesanan Berhasil!",
                fontSize = 27.sp,
                lineHeight = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Espresso,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            // DESKRIPSI
            Text(
                text = "Terima kasih sudah memesan di Kopi dan Nyemil. Pesananmu berhasil dikonfirmasi dan siap diproses.",
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = MutedBrown,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(28.dp))

            // KARTU DETAIL PESANAN
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ReceiptLong,
                            contentDescription = null,
                            tint = Caramel,
                            modifier = Modifier.size(21.dp)
                        )

                        Spacer(modifier = Modifier.width(9.dp))

                        Text(
                            text = "Detail Pesanan",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            color = Espresso
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    KonfirmasiDetailRow(
                        label = "Nama Penerima",
                        value = recipient
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    KonfirmasiDetailRow(
                        label = "Jumlah Produk",
                        value = "$totalItems item"
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    HorizontalDivider(
                        color = Color(0xFFEDE4DA),
                        thickness = 1.dp
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    KonfirmasiDetailRow(
                        label = "Total Pembayaran",
                        value = totalRupiah,
                        isTotal = true
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // INFORMASI RIWAYAT
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color(0xFFF0E7DC))
                    .padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.ReceiptLong,
                    contentDescription = null,
                    tint = Espresso,
                    modifier = Modifier.size(23.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "Detail pesananmu sudah tersimpan di menu Pesanan → Riwayat Pesanan.",
                    fontSize = 12.sp,
                    lineHeight = 19.sp,
                    color = Espresso
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Have a brew-tiful day! ☕",
                fontSize = 13.sp,
                color = MutedBrown,
                textAlign = TextAlign.Center
            )
        }

        // TOMBOL TETAP DI BAWAH
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .navigationBarsPadding()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 14.dp,
                    bottom = 14.dp
                )
        ) {
            CoffeeButton(
                text = "Kembali ke Home",
                onClick = onHome
            )
        }
    }
}

// BARIS DETAIL PESANAN
@Composable
private fun KonfirmasiDetailRow(
    label: String,
    value: String,
    isTotal: Boolean = false
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = if (isTotal) 14.sp else 13.sp,
            fontWeight = if (isTotal) {
                FontWeight.SemiBold
            } else {
                FontWeight.Normal
            },
            color = if (isTotal) Espresso else MutedBrown,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = value,
            fontSize = if (isTotal) 18.sp else 13.sp,
            fontWeight = if (isTotal) {
                FontWeight.Bold
            } else {
                FontWeight.SemiBold
            },
            color = Espresso,
            textAlign = TextAlign.End
        )
    }
}

// PREVIEW
@Preview(
    name = "Konfirmasi Pesanan",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun KonfirmasiScreenPreview() {
    MaterialTheme {
        KonfirmasiScreen(
            recipient = "Naila Aghna",
            totalItems = 3,
            totalPrice = 75000,
            onHome = {}
        )
    }
}
