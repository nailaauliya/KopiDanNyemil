package lat.pam.kopidannyemil.model

import lat.pam.kopidannyemil.R

data class Product(
    val id: Int,
    val name: String,
    val category: String,
    val price: Int,
    val image: Int,
    val description: String
)

val dummyProducts = listOf(

    // KATEGORI KOPI
    Product(
        id = 1,
        name = "Kopi Susu Gula Aren",
        category = "Kopi",
        price = 23000,
        image = R.drawable.kopi_susu,
        description = "Espresso, susu, dan gula aren"
    ),

    Product(
        id = 2,
        name = "Cappuccino",
        category = "Kopi",
        price = 25000,
        image = R.drawable.cappuccino,
        description = "Espresso dengan foam susu lembut"
    ),

    Product(
        id = 3,
        name = "Iced Americano",
        category = "Kopi",
        price = 22000,
        image = R.drawable.iced_americano,
        description = "Espresso dan air dingin dengan es"
    ),

    Product(
        id = 4,
        name = "Orange Americano",
        category = "Kopi",
        price = 28000,
        image = R.drawable.orange_americano,
        description = "Espresso dengan kesegaran jeruk"
    ),

    // KATEGORI NON KOPI
    Product(
        id = 5,
        name = "Matcha Latte",
        category = "Non Kopi",
        price = 27000,
        image = R.drawable.matcha_latte,
        description = "Matcha Jepang dengan susu segar"
    ),

    Product(
        id = 6,
        name = "Mocktails",
        category = "Non Kopi",
        price = 29000,
        image = R.drawable.mocktails,
        description = "Minuman segar dengan campuran buah"
    ),

    // KATEGORI CAMILAN
    Product(
        id = 7,
        name = "Donat Cokelat",
        category = "Camilan",
        price = 16000,
        image = R.drawable.donat_cokelat,
        description = "Donat lembut dengan glaze cokelat"
    ),

    Product(
        id = 8,
        name = "Butter Croissant",
        category = "Camilan",
        price = 22000,
        image = R.drawable.croissant,
        description = "Pastry renyah dengan aroma butter"
    ),

    Product(
        id = 9,
        name = "Choco Cookies",
        category = "Camilan",
        price = 15000,
        image = R.drawable.cookies,
        description = "Cookies renyah dengan cokelat"
    ),

    Product(
        id = 10,
        name = "Blueberry Cheesecake",
        category = "Camilan",
        price = 35000,
        image = R.drawable.blueberry_cheesecake,
        description = "Cheesecake lembut dengan blueberry"
    )
)
