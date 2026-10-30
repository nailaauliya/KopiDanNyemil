package lat.pam.kopidannyemil.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import lat.pam.kopidannyemil.R
import lat.pam.kopidannyemil.design.*
import lat.pam.kopidannyemil.model.Product
import lat.pam.kopidannyemil.model.dummyProducts

// ========================================
// FORMAT HARGA RUPIAH
// ========================================

private fun formatRupiah(price: Int): String {
    return "Rp " + "%,d".format(price).replace(',', '.')
}

// ========================================
// HOME SCREEN
// ========================================

@Composable
fun HomeScreen(
    name: String,
    quantities: Map<Int, Int>,
    onAdd: (Int) -> Unit,
    onRemove: (Int) -> Unit,
    onOrder: () -> Unit,
    onProfile: () -> Unit
) {
    var search by remember {
        mutableStateOf("")
    }

    var selectedCategory by remember {
        mutableStateOf("Semua")
    }

    val categories = listOf(
        "Semua",
        "Kopi",
        "Non Kopi",
        "Camilan"
    )

    // FILTER PENCARIAN DAN KATEGORI
    val filteredProducts = dummyProducts.filter { product ->
        (selectedCategory == "Semua" ||
                product.category == selectedCategory) &&
                (
                        product.name.contains(
                            search,
                            ignoreCase = true
                        ) ||
                                product.description.contains(
                                    search,
                                    ignoreCase = true
                                )
                        )
    }

    // TOTAL KERANJANG
    val totalItems = quantities.values.sum()

    val totalPrice = dummyProducts.sumOf { product ->
        product.price * (quantities[product.id] ?: 0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
    ) {

        // ========================================
        // HEADER
        // ========================================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 22.dp,
                    end = 22.dp,
                    top = 20.dp,
                    bottom = 16.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "GOOD DAY, COFFEE LOVER",
                    fontSize = 10.sp,
                    letterSpacing = 1.4.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Caramel
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Halo, ${name.substringBefore(" ")}!",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Espresso
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "Mau nyemil apa hari ini?",
                    fontSize = 13.sp,
                    color = MutedBrown
                )
            }

            // TOMBOL PROFIL
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFF0E5D8))
                    .clickable { onProfile() },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(
                        R.drawable.logo_kopi
                    ),
                    contentDescription = "Buka Profil",
                    modifier = Modifier.size(40.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }

        // ========================================
        // PENCARIAN
        // ========================================

        OutlinedTextField(
            value = search,
            onValueChange = {
                search = it
            },
            placeholder = {
                Text(
                    text = "Cari menu favoritmu...",
                    fontSize = 13.sp
                )
            },
            leadingIcon = {
                Text(
                    text = "⌕",
                    fontSize = 26.sp,
                    color = Espresso
                )
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            shape = RoundedCornerShape(15.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Espresso,
                unfocusedBorderColor = Color(0xFFE6DACE),
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(18.dp))

        // ========================================
        // BANNER FOTO KOPI
        // ========================================

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp)
                .height(155.dp)
                .clip(RoundedCornerShape(20.dp))
        ) {
            Image(
                painter = painterResource(
                    R.drawable.coffee_signup
                ),
                contentDescription = "Banner Kopi dan Nyemil",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                Espresso.copy(alpha = 0.90f),
                                Espresso.copy(alpha = 0.55f),
                                Color.Transparent
                            )
                        )
                    )
            )

            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(20.dp)
            ) {
                Text(
                    text = "YOUR COFFEE MOMENT",
                    fontSize = 9.sp,
                    letterSpacing = 1.4.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFD4A5)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Good coffee,\ngood mood.",
                    fontSize = 24.sp,
                    lineHeight = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Temukan favoritmu hari ini.",
                    fontSize = 11.sp,
                    color = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // ========================================
        // KATEGORI
        // ========================================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            horizontalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            categories.forEach { category ->

                val selected = selectedCategory == category

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            if (selected) {
                                Espresso
                            } else {
                                Color(0xFFF0E8DE)
                            }
                        )
                        .clickable {
                            selectedCategory = category
                        }
                        .padding(vertical = 11.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = category,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = if (selected) {
                            Color.White
                        } else {
                            Espresso
                        },
                        maxLines = 1
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(22.dp))

        // ========================================
        // JUDUL MENU
        // ========================================

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Menu Pilihan",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Espresso
            )

            Text(
                text = "${filteredProducts.size} menu",
                fontSize = 12.sp,
                color = MutedBrown
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        // ========================================
        // DAFTAR PRODUK - SATU BARIS PER PRODUK
        // ========================================

        if (filteredProducts.isEmpty()) {

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Menu tidak ditemukan.",
                    color = MutedBrown
                )
            }

        } else {

            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(
                    start = 22.dp,
                    end = 22.dp,
                    bottom = 18.dp
                ),
                verticalArrangement =
                    Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = filteredProducts,
                    key = { it.id }
                ) { product ->

                    CoffeeProductCard(
                        product = product,
                        quantity = quantities[product.id] ?: 0,
                        onAdd = {
                            onAdd(product.id)
                        },
                        onRemove = {
                            onRemove(product.id)
                        }
                    )
                }
            }
        }

        // ========================================
        // RINGKASAN KERANJANG
        // ========================================

        if (totalItems > 0) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(
                        horizontal = 22.dp,
                        vertical = 12.dp
                    )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "$totalItems item dipilih",
                            fontSize = 12.sp,
                            color = MutedBrown
                        )

                        Text(
                            text = formatRupiah(totalPrice),
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            color = Espresso
                        )
                    }

                    Button(
                        onClick = onOrder,
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Espresso
                        )
                    ) {
                        Text(
                            text = "Lihat Keranjang →",
                            fontSize = 12.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }

        // ========================================
        // BOTTOM NAVIGATION
        // ========================================

        HorizontalDivider(
            color = Color(0xFFEDE5DB)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(
                    horizontal = 22.dp,
                    vertical = 11.dp
                ),
            horizontalArrangement =
                Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            CoffeeNavItem(
                symbol = "⌂",
                label = "Home",
                selected = true,
                onClick = {}
            )

            CoffeeNavItem(
                symbol = "▤",
                label = "Order",
                selected = false,
                onClick = onOrder
            )

            CoffeeNavItem(
                symbol = "◯",
                label = "Profile",
                selected = false,
                onClick = onProfile
            )
        }
    }
}

// ========================================
// KARTU PRODUK HORIZONTAL
// ========================================

@Composable
private fun CoffeeProductCard(
    product: Product,
    quantity: Int,
    onAdd: () -> Unit,
    onRemove: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(17.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = BorderStroke(
            width = 1.dp,
            color = Color(0xFFE8DDD1)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // FOTO PRODUK DI KIRI
            Image(
                painter = painterResource(product.image),
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(86.dp)
                    .clip(RoundedCornerShape(13.dp))
            )

            Spacer(modifier = Modifier.width(14.dp))

            // INFORMASI PRODUK
            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = product.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Espresso,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                // DESKRIPSI LANGSUNG DARI PRODUCT.KT
                Text(
                    text = product.description,
                    fontSize = 12.sp,
                    lineHeight = 17.sp,
                    color = MutedBrown,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = formatRupiah(product.price),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Espresso
                )

                Spacer(modifier = Modifier.height(10.dp))

                // TOMBOL TAMBAH DAN KURANG
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    if (quantity > 0) {

                        Box(
                            modifier = Modifier
                                .size(27.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFF0E8DE))
                                .clickable {
                                    onRemove()
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "−",
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold,
                                color = Espresso
                            )
                        }

                        Spacer(modifier = Modifier.width(9.dp))

                        Text(
                            text = "$quantity",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Espresso
                        )

                        Spacer(modifier = Modifier.width(9.dp))
                    }

                    Box(
                        modifier = Modifier
                            .size(27.dp)
                            .clip(CircleShape)
                            .background(Espresso)
                            .clickable {
                                onAdd()
                            },
                        contentAlignment = Alignment.Center
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

// ========================================
// BOTTOM NAVIGATION ITEM
// ========================================

@Composable
private fun CoffeeNavItem(
    symbol: String,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable {
                onClick()
            }
            .padding(
                horizontal = 16.dp,
                vertical = 3.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = symbol,
            fontSize = 24.sp,
            color = if (selected) {
                Espresso
            } else {
                MutedBrown
            }
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = if (selected) {
                FontWeight.Bold
            } else {
                FontWeight.Normal
            },
            color = if (selected) {
                Espresso
            } else {
                MutedBrown
            }
        )
    }
}

// ========================================
// PREVIEW HOME
// ========================================

@Preview(
    name = "05 - Home",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen(
            name = "Naila Aghna",
            quantities = mapOf(
                1 to 1,
                2 to 1
            ),
            onAdd = {},
            onRemove = {},
            onOrder = {},
            onProfile = {}
        )
    }
}
