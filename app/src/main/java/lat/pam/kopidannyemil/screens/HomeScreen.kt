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

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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

    val totalItems = quantities.values.sum()

    val totalPrice = dummyProducts.sumOf { product ->
        product.price * (quantities[product.id] ?: 0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
    ) {

        // Header
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
                    text = "KOPI DAN NYEMIL",
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
                    .clickable(onClick = onProfile),
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

        // Pencarian
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
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Cari",
                    tint = Espresso
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

        // Banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp)
                .height(155.dp)
                .clip(RoundedCornerShape(20.dp))
        ) {
            Image(
                painter = painterResource(R.drawable.coffee_signup),
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
                    text = "TAKE A COFFEE BREAK",
                    fontSize = 9.sp,
                    letterSpacing = 1.4.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFD4A5)
                )

                Spacer(Modifier.height(10.dp))

                Text(
                    text = "Coffee first,\nsnacks later.",
                    fontSize = 24.sp,
                    lineHeight = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "Pilih kopi dan camilan favoritmu.",
                    fontSize = 11.sp,
                    color = Color.White
                )
            }
        }

        Spacer(Modifier.height(20.dp))

        // Kategori menu
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

        // Judul daftar menu
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

        // Daftar produk
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
                verticalArrangement = Arrangement.spacedBy(12.dp)
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

        // Ringkasan keranjang
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
                    horizontalArrangement = Arrangement.SpaceBetween,
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

        // Bottom navigation
        HorizontalDivider(
            color = Color(0xFFEDE5DB)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(
                    horizontal = 24.dp,
                    vertical = 10.dp
                ),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CoffeeNavItem(
                icon = Icons.Filled.Home,
                label = "Home",
                selected = true,
                onClick = {}
            )

            CoffeeNavItem(
                icon = Icons.Filled.ShoppingCart,
                label = "Keranjang",
                selected = false,
                onClick = onOrder
            )

            CoffeeNavItem(
                icon = Icons.Filled.Person,
                label = "Profil",
                selected = false,
                onClick = onProfile
            )
        }
    }
}

// Kartu produk
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
            Image(
                painter = painterResource(product.image),
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(86.dp)
                    .clip(RoundedCornerShape(13.dp))
            )

            Spacer(Modifier.width(14.dp))

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

                Spacer(Modifier.height(4.dp))

                Text(
                    text = product.description,
                    fontSize = 12.sp,
                    lineHeight = 17.sp,
                    color = MutedBrown,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(Modifier.height(6.dp))

                Text(
                    text = formatRupiah(product.price),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Espresso
                )

                Spacer(Modifier.height(10.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (quantity > 0) {
                        Box(
                            modifier = Modifier
                                .size(27.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFF0E8DE))
                                .clickable(onClick = onRemove),
                            contentAlignment = Alignment.Center
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
                            text = "$quantity",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Espresso
                        )

                        Spacer(Modifier.width(9.dp))
                    }

                    Box(
                        modifier = Modifier
                            .size(27.dp)
                            .clip(CircleShape)
                            .background(Espresso)
                            .clickable(onClick = onAdd),
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

// Item bottom navigation
@Composable
private fun CoffeeNavItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .padding(
                horizontal = 14.dp,
                vertical = 5.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (selected) Espresso else MutedBrown,
            modifier = Modifier.size(23.dp)
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = if (selected) {
                FontWeight.SemiBold
            } else {
                FontWeight.Normal
            },
            color = if (selected) Espresso else MutedBrown
        )
    }
}

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
