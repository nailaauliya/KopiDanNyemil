package lat.pam.kopidannyemil.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import lat.pam.kopidannyemil.components.CoffeeButton
import lat.pam.kopidannyemil.design.*
import lat.pam.kopidannyemil.model.dummyProducts

data class ItemRiwayat(
    val nama: String,
    val jumlah: Int,
    val harga: Int
)

data class RiwayatPesanan(
    val nomor: Int,
    val penerima: String,
    val produk: List<ItemRiwayat>,
    val totalHarga: Int
)

private fun formatRupiahPesanan(harga: Int): String {
    return "Rp " + "%,d".format(harga).replace(',', '.')
}

@Composable
fun PesananScreen(
    quantities: Map<Int, Int>,
    riwayat: List<RiwayatPesanan>,
    onAdd: (Int) -> Unit,
    onRemove: (Int) -> Unit,
    onBack: () -> Unit,
    onCheckout: () -> Unit
) {
    var selectedTab by remember { mutableIntStateOf(0) }

    val selectedProducts = dummyProducts.filter {
        (quantities[it.id] ?: 0) > 0
    }

    val totalItems = quantities.values.sum()

    val totalPrice = dummyProducts.sumOf {
        it.price * (quantities[it.id] ?: 0)
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
                    bottom = 8.dp
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
                text = "Pesanan Saya",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Espresso
            )
        }

        HorizontalDivider(
            color = Color(0xFFEAE0D5)
        )

        // TAB DENGAN INDIKATOR COKELAT CUSTOM
        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = Cream,
            contentColor = Espresso,
            indicator = { tabPositions ->

                // Indikator custom, bukan indikator bawaan
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(
                            tabPositions[selectedTab]
                        )
                        .height(3.dp)
                        .background(Espresso)
                )
            },
            divider = {
                HorizontalDivider(
                    color = Color(0xFFEAE0D5),
                    thickness = 1.dp
                )
            }
        ) {
            listOf(
                "Keranjang",
                "Riwayat Pesanan"
            ).forEachIndexed { index, title ->

                Tab(
                    selected = selectedTab == index,
                    onClick = {
                        selectedTab = index
                    },
                    selectedContentColor = Espresso,
                    unselectedContentColor = MutedBrown,
                    text = {
                        Text(
                            text = title,
                            fontSize = 13.sp,
                            color = if (selectedTab == index)
                                Espresso
                            else
                                MutedBrown,
                            fontWeight = if (selectedTab == index)
                                FontWeight.Bold
                            else
                                FontWeight.Normal
                        )
                    }
                )
            }
        }

        when (selectedTab) {

            // KERANJANG
            0 -> {
                if (selectedProducts.isEmpty()) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "☕",
                            fontSize = 60.sp
                        )

                        Spacer(Modifier.height(16.dp))

                        Text(
                            text = "Keranjangmu masih kosong",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Espresso,
                            textAlign = TextAlign.Center
                        )

                        Spacer(Modifier.height(8.dp))

                        Text(
                            text = "Yuk, pilih kopi dan camilan favoritmu dulu!",
                            color = MutedBrown,
                            fontSize = 13.sp,
                            textAlign = TextAlign.Center
                        )

                        Spacer(Modifier.height(26.dp))

                        CoffeeButton(
                            text = "Lihat Menu",
                            onClick = onBack
                        )
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.weight(1f),
                        contentPadding = PaddingValues(20.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        item {
                            Text(
                                text = "$totalItems item dalam keranjang",
                                color = MutedBrown,
                                fontSize = 13.sp
                            )
                        }

                        items(
                            items = selectedProducts,
                            key = { it.id }
                        ) { product ->

                            val jumlah = quantities[product.id] ?: 0

                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(17.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White
                                )
                            ) {
                                Row(
                                    modifier = Modifier.padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(
                                            product.image
                                        ),
                                        contentDescription = product.name,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(84.dp)
                                            .clip(
                                                RoundedCornerShape(13.dp)
                                            )
                                    )

                                    Spacer(Modifier.width(12.dp))

                                    Column(
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Text(
                                            text = product.name,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 14.sp,
                                            color = Espresso
                                        )

                                        Spacer(Modifier.height(6.dp))

                                        Text(
                                            text = formatRupiahPesanan(
                                                product.price
                                            ),
                                            color = Espresso,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Medium
                                        )

                                        Spacer(Modifier.height(11.dp))

                                        // TOMBOL PLUS MINUS SAMA DENGAN HOME
                                        Row(
                                            verticalAlignment =
                                                Alignment.CenterVertically
                                        ) {
                                            Box(
                                                modifier = Modifier
                                                    .size(27.dp)
                                                    .clip(CircleShape)
                                                    .background(
                                                        Color(0xFFF0E8DE)
                                                    )
                                                    .clickable {
                                                        onRemove(product.id)
                                                    },
                                                contentAlignment =
                                                    Alignment.Center
                                            ) {
                                                Text(
                                                    text = "−",
                                                    fontSize = 17.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Espresso
                                                )
                                            }

                                            Spacer(Modifier.width(9.dp))

                                            Text(
                                                text = "$jumlah",
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Espresso
                                            )

                                            Spacer(Modifier.width(9.dp))

                                            Box(
                                                modifier = Modifier
                                                    .size(27.dp)
                                                    .clip(CircleShape)
                                                    .background(Espresso)
                                                    .clickable {
                                                        onAdd(product.id)
                                                    },
                                                contentAlignment =
                                                    Alignment.Center
                                            ) {
                                                Text(
                                                    text = "+",
                                                    fontSize = 18.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.White
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    // RINGKASAN KERANJANG
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .navigationBarsPadding()
                            .padding(
                                horizontal = 22.dp,
                                vertical = 16.dp
                            )
                    ) {
                        Text(
                            text = "Ringkasan Pesanan",
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp,
                            color = Espresso
                        )

                        Spacer(Modifier.height(14.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Total Item",
                                color = MutedBrown,
                                fontSize = 13.sp
                            )

                            Text(
                                text = "$totalItems item",
                                color = Espresso,
                                fontSize = 13.sp
                            )
                        }

                        Spacer(Modifier.height(12.dp))

                        HorizontalDivider(
                            color = Color(0xFFEDE4DA)
                        )

                        Spacer(Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Total Harga",
                                fontWeight = FontWeight.Bold,
                                color = Espresso
                            )

                            Text(
                                text = formatRupiahPesanan(totalPrice),
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Espresso
                            )
                        }

                        Spacer(Modifier.height(16.dp))

                        CoffeeButton(
                            text = "Lanjut ke Alamat  →",
                            onClick = onCheckout
                        )
                    }
                }
            }

            // RIWAYAT PESANAN
            1 -> {
                if (riwayat.isEmpty()) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ReceiptLong,
                            contentDescription = null,
                            modifier = Modifier.size(64.dp),
                            tint = MutedBrown
                        )

                        Spacer(Modifier.height(18.dp))

                        Text(
                            text = "Belum Ada Riwayat Pesanan",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Espresso,
                            textAlign = TextAlign.Center
                        )

                        Spacer(Modifier.height(8.dp))

                        Text(
                            text = "Pesanan yang berhasil dikonfirmasi akan muncul di sini.",
                            fontSize = 13.sp,
                            color = MutedBrown,
                            textAlign = TextAlign.Center
                        )
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(20.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        items(
                            items = riwayat.asReversed(),
                            key = { it.nomor }
                        ) { pesanan ->

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
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement =
                                            Arrangement.SpaceBetween,
                                        verticalAlignment =
                                            Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = "Pesanan #${
                                                pesanan.nomor.toString()
                                                    .padStart(3, '0')
                                            }",
                                            fontWeight = FontWeight.Bold,
                                            color = Espresso,
                                            fontSize = 15.sp
                                        )

                                        Text(
                                            text = "Dikonfirmasi",
                                            color = Color(0xFF51815B),
                                            fontSize = 11.sp
                                        )
                                    }

                                    Spacer(Modifier.height(10.dp))

                                    Text(
                                        text = "Penerima: ${pesanan.penerima}",
                                        color = MutedBrown,
                                        fontSize = 12.sp
                                    )

                                    Spacer(Modifier.height(14.dp))

                                    pesanan.produk.forEach { item ->
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(vertical = 5.dp),
                                            horizontalArrangement =
                                                Arrangement.SpaceBetween
                                        ) {
                                            Text(
                                                text = "${item.nama} × ${item.jumlah}",
                                                fontSize = 12.sp,
                                                color = Espresso,
                                                modifier = Modifier.weight(1f)
                                            )

                                            Text(
                                                text = formatRupiahPesanan(
                                                    item.harga * item.jumlah
                                                ),
                                                fontSize = 12.sp,
                                                color = MutedBrown
                                            )
                                        }
                                    }

                                    Spacer(Modifier.height(12.dp))

                                    HorizontalDivider(
                                        color = Color(0xFFEDE4DA)
                                    )

                                    Spacer(Modifier.height(12.dp))

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement =
                                            Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = "${
                                                pesanan.produk.sumOf {
                                                    it.jumlah
                                                }
                                            } item",
                                            fontSize = 12.sp,
                                            color = MutedBrown
                                        )

                                        Text(
                                            text = formatRupiahPesanan(
                                                pesanan.totalHarga
                                            ),
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 15.sp,
                                            color = Espresso
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
