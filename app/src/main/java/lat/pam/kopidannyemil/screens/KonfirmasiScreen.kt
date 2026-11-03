package lat.pam.kopidannyemil.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import lat.pam.kopidannyemil.components.CoffeeButton
import lat.pam.kopidannyemil.design.*

// ========================================
// KONFIRMASI PESANAN
// ========================================

@Composable
fun KonfirmasiScreen(
    recipient: String,
    totalItems: Int,
    totalPrice: Int,
    onHome: () -> Unit
) {

    val rupiah = "Rp " +
            "%,d".format(totalPrice).replace(',', '.')

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .padding(horizontal = 26.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // IKON BERHASIL
        Box(
            modifier = Modifier
                .size(116.dp)
                .background(
                    color = Color(0xFFF0E5D8),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(84.dp)
                    .background(
                        color = Espresso,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "✓",
                    fontSize = 46.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // JUDUL
        Text(
            text = "Pesanan Berhasil!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Espresso,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        // DESKRIPSI
        Text(
            text = "Terima kasih sudah memesan di " +
                    "Kopi dan Nyemil. Pesananmu berhasil " +
                    "dikonfirmasi dan siap diproses.",
            fontSize = 14.sp,
            lineHeight = 23.sp,
            color = MutedBrown,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        // DETAIL PESANAN
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(22.dp)
        ) {

            Text(
                text = "DETAIL PESANAN",
                fontSize = 11.sp,
                letterSpacing = 1.4.sp,
                fontWeight = FontWeight.Bold,
                color = Caramel
            )

            Spacer(modifier = Modifier.height(20.dp))

            DetailRow(
                label = "Nama Penerima",
                value = recipient
            )

            Spacer(modifier = Modifier.height(16.dp))

            DetailRow(
                label = "Jumlah Produk",
                value = "$totalItems item"
            )

            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider(
                color = Color(0xFFEDE4DA)
            )

            Spacer(modifier = Modifier.height(16.dp))

            DetailRow(
                label = "Total Pesanan",
                value = rupiah
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // TOMBOL KEMBALI
        CoffeeButton(
            text = "Kembali ke Home",
            onClick = onHome
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Have a brew-tiful day!",
            fontSize = 12.sp,
            color = MutedBrown
        )
    }
}

// KOMPONEN DETAIL PESANAN

@Composable
private fun DetailRow(
    label: String,
    value: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = label,
            fontSize = 13.sp,
            color = MutedBrown,
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = value,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = Espresso,
            textAlign = TextAlign.End
        )
    }
}

// PREVIEW KONFIRMASI

@Preview(
    name = "08 - Konfirmasi Pesanan",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun KonfirmasiScreenPreview() {

    MaterialTheme {
        KonfirmasiScreen(
            recipient = "Naila Aghna",
            totalItems = 2,
            totalPrice = 48000,
            onHome = {}
        )
    }
}
