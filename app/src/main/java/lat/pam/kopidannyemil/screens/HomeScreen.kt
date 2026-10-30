package lat.pam.kopidannyemil.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import lat.pam.kopidannyemil.R
import lat.pam.kopidannyemil.components.CoffeeButton
import lat.pam.kopidannyemil.design.*
import lat.pam.kopidannyemil.model.Product
import lat.pam.kopidannyemil.model.dummyProducts

private fun formatRupiah(price: Int): String {
    return "Rp " + "%,d".format(price).replace(',', '.')
}

@Composable
fun HomeScreen(
    name: String,
    quantities: Map<Int, Int>,
    onAdd: (Int) -> Unit,
    onRemove: (Int) -> Unit,
    onOrder: () -> Unit,
    onProfile: () -> Unit
) {
    var search by remember { mutableStateOf("") }
    var selectedCategory by remember {
        mutableStateOf("Semua")
    }

    val categories = listOf(
        "Semua", "Kopi", "Non Kopi", "Camilan"
    )

    val filteredProducts = dummyProducts.filter {
        (selectedCategory == "Semua" ||
                it.category == selectedCategory) &&
                it.name.contains(search, ignoreCase = true)
    }

    val totalItems = quantities.values.sum()
    val totalPrice = dummyProducts.sumOf {
        it.price * (quantities[it.id] ?: 0)
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

                Spacer(Modifier.height(6.dp))

                Text(
                    text = "Halo, ${name.substringBefore(" ")}!",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Espresso
                )

                Spacer(Modifier.height(3.dp))

                Text(
                    text = "Mau nyemil apa hari ini?",
                    fontSize = 13.sp,
                    color = MutedBrown
                )
            }

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFF0E5D8))
                    .clickable { onProfile() },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.logo_kopi),
                    contentDescription = "Buka Profil",
                    modifier = Modifier.size(40.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }

        // PENCARIAN
        OutlinedTextField(
            value = search,
            onValueChange = { search = it },
            placeholder = {
                Text(
                    text = "Cari menu favoritmu...",
                    fontSize = 13.sp
                )
            },
            leadingIcon = {
                Text(
                    text = "⌕",
                    fontSize = 27.sp,
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

        Spacer(Modifier.height(18.dp))

        // BANNER FOTO
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
                contentDescription = "Banner kopi dan camilan",
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

                Spacer(Modifier.height(10.dp))

                Text(
                    text = "Good coffee,\ngood mood.",
                    fontSize = 24.sp,
                    lineHeight = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "Temukan favoritmu hari ini.",
                    fontSize = 11.sp,
                    color = Color.White
                )
            }
        }

        Spacer(Modifier.height(20.dp))

        // KATEGORI
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
                            if (selected) Espresso
                            else Color(0xFFF0E8DE)
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
                        color = if (selected) Color.White
                        else Espresso,
                        maxLines = 1
                    )
                }
            }
        }

        Spacer(Modifier.height(22.dp))

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

        Spacer(Modifier.height(14.dp))

        // DAFTAR PRODUK
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
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(
                    start = 22.dp,
                    end = 22.dp,
                    bottom = 18.dp
                ),
                horizontalArrangement =
                    Arrangement.spacedBy(12.dp),
                verticalArrangement =
                    Arrangement.spacedBy(14.dp)
            ) {
                items(
                    items = filteredProducts,
                    key = { it.id }
                ) { product ->
                    CoffeeProductCard(
                        product = product,
                        quantity = quantities[product.id] ?: 0,
                        onAdd = { onAdd(product.id) },
                        onRemove = { onRemove(product.id) }
                    )
                }
            }
        }

        // RINGKASAN KERANJANG
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
                            text = "Pesan  →",
                            fontSize = 13.sp
                        )
                    }
                }
            }
        }

        // BOTTOM NAVIGATION
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
            horizontalArrangement = Arrangement.SpaceAround,
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

// KARTU PRODUK
@Composable
private fun CoffeeProductCard(
    product: Product,
    quantity: Int,
    onAdd: () -> Unit,
    onRemove: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        )
    ) {
        Column {
            Image(
                painter = painterResource(product.image),
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(125.dp)
            )

            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Text(
                    text = product.name,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Espresso,
                    minLines = 2,
                    maxLines = 2,
                    lineHeight = 17.sp,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(Modifier.height(7.dp))

                Text(
                    text = formatRupiah(product.price),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Espresso
                )

                Spacer(Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (quantity > 0) {
                        Box(
                            modifier = Modifier
                                .size(28.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFF0E8DE))
                                .clickable { onRemove() },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "−",
                                fontSize = 18.sp,
                                color = Espresso
                            )
                        }

                        Spacer(Modifier.width(9.dp))

                        Text(
                            text = "$quantity",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Espresso
                        )

                        Spacer(Modifier.width(9.dp))
                    }

                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(Espresso)
                            .clickable { onAdd() },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "+",
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

// BOTTOM NAVIGATION ITEM
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
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 3.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = symbol,
            fontSize = 24.sp,
            color = if (selected) Espresso else MutedBrown
        )

        Spacer(Modifier.height(2.dp))

        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = if (selected) FontWeight.Bold
            else FontWeight.Normal,
            color = if (selected) Espresso else MutedBrown
        )
    }
}

// PREVIEW
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
            quantities = mapOf(1 to 1, 2 to 1),
            onAdd = {},
            onRemove = {},
            onOrder = {},
            onProfile = {}
        )
    }
}
