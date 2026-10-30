package lat.pam.kopidannyemil.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import lat.pam.kopidannyemil.components.CoffeeButton
import lat.pam.kopidannyemil.design.*
import lat.pam.kopidannyemil.model.Product
import lat.pam.kopidannyemil.model.dummyProducts

private fun hargaRupiah(price: Int): String {
    return "Rp " + "%,d".format(price).replace(',', '.')
}

// ========================================
// HALAMAN KERANJANG
// ========================================

@Composable
fun KeranjangScreen(
    quantities: Map<Int, Int>,
    onAdd: (Int) -> Unit,
    onRemove: (Int) -> Unit,
    onBack: () -> Unit,
    onCheckout: () -> Unit
) {
    val selectedProducts = dummyProducts.filter { product ->
        (quantities[product.id] ?: 0) > 0
    }

    val totalItems = quantities.values.sum()

    val totalPrice = dummyProducts.sumOf { product ->
        product.price * (quantities[product.id] ?: 0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
    ) {

        // HEADER
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 12.dp,
                    end = 24.dp,
                    top = 16.dp,
                    bottom = 12.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Text(
                    text = "←",
                    fontSize = 26.sp,
                    color = Espresso
                )
            }

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = "Keranjang Pesanan",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Espresso
            )
        }

        HorizontalDivider(
            color = Color(0xFFEAE0D5)
        )

        if (selectedProducts.isEmpty()) {

            // KERANJANG KOSONG
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
                    fontSize = 64.sp
                )

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "Keranjangmu masih kosong",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = Espresso
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Yuk, pilih kopi dan camilan favoritmu dulu!",
                    fontSize = 13.sp,
                    lineHeight = 21.sp,
                    color = MutedBrown
                )

                Spacer(modifier = Modifier.height(28.dp))

                CoffeeButton(
                    text = "Lihat Menu",
                    onClick = onBack
                )
            }

        } else {

            // DAFTAR PRODUK DIPILIH
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(
                    start = 20.dp,
                    end = 20.dp,
                    top = 20.dp,
                    bottom = 20.dp
                ),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                item {
                    Text(
                        text = "$totalItems item dalam keranjang",
                        fontSize = 13.sp,
                        color = MutedBrown
                    )
                }

                items(
                    items = selectedProducts,
                    key = { it.id }
                ) { product ->
                    KeranjangProductCard(
                        product = product,
                        quantity = quantities[product.id] ?: 0,
                        onAdd = { onAdd(product.id) },
                        onRemove = { onRemove(product.id) }
                    )
                }
            }

            // RINGKASAN PEMBAYARAN
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(
                        horizontal = 22.dp,
                        vertical = 20.dp
                    )
            ) {
                Text(
                    text = "Ringkasan Pesanan",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Espresso
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total Item",
                        fontSize = 13.sp,
                        color = MutedBrown
                    )

                    Text(
                        text = "$totalItems item",
                        fontSize = 13.sp,
                        color = Espresso
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                HorizontalDivider(
                    color = Color(0xFFEDE4DA)
                )

                Spacer(modifier = Modifier.height(12.dp))

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
                        text = hargaRupiah(totalPrice),
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = Espresso
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                CoffeeButton(
                    text = "Lanjut ke Alamat  →",
                    onClick = onCheckout
                )
            }
        }
    }
}

// ========================================
// KARTU PRODUK KERANJANG
// ========================================

@Composable
private fun KeranjangProductCard(
    product: Product,
    quantity: Int,
    onAdd: () -> Unit,
    onRemove: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(product.image),
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(13.dp))
            )

            Spacer(modifier = Modifier.width(14.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = product.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Espresso,
                    lineHeight = 19.sp
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = hargaRupiah(product.price),
                    fontSize = 13.sp,
                    color = Caramel,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    ButtonJumlah(
                        symbol = "−",
                        filled = false,
                        onClick = onRemove
                    )

                    Text(
                        text = "$quantity",
                        modifier = Modifier.padding(
                            horizontal = 14.dp
                        ),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Espresso
                    )

                    ButtonJumlah(
                        symbol = "+",
                        filled = true,
                        onClick = onAdd
                    )
                }
            }
        }
    }
}

// ========================================
// TOMBOL JUMLAH PRODUK
// ========================================

@Composable
private fun ButtonJumlah(
    symbol: String,
    filled: Boolean,
    onClick: () -> Unit
) {
    FilledIconButton(
        onClick = onClick,
        modifier = Modifier.size(32.dp),
        shape = CircleShape,
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = if (filled) {
                Espresso
            } else {
                Color(0xFFF0E8DE)
            },
            contentColor = if (filled) {
                Color.White
            } else {
                Espresso
            }
        )
    ) {
        Text(
            text = symbol,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

// ========================================
// PREVIEW
// ========================================

@Preview(
    name = "Keranjang Pesanan",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun KeranjangScreenPreview() {
    MaterialTheme {
        KeranjangScreen(
            quantities = mapOf(
                1 to 2,
                2 to 1
            ),
            onAdd = {},
            onRemove = {},
            onBack = {},
            onCheckout = {}
        )
    }
}
