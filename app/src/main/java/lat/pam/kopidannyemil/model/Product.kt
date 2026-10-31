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

    // Kategori Kopi

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

    Product(
        id = 14,
        name = "Caramel Frappuccino",
        category = "Kopi",
        price = 32000,
        image = R.drawable.caramel_frappucino,
        description = "Kopi blended dengan susu, es, dan karamel"
    ),

    Product(
        id = 16,
        name = "Avocado Coffee",
        category = "Kopi",
        price = 30000,
        image = R.drawable.avocado_coffee,
        description = "Perpaduan alpukat, espresso, dan susu"
    ),

    // Kategori Non Kopi

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

    Product(
        id = 13,
        name = "Hot Choco",
        category = "Non Kopi",
        price = 25000,
        image = R.drawable.hot_choco,
        description = "Minuman cokelat hangat dengan susu"
    ),

    Product(
        id = 15,
        name = "Cookies n Cream Frappe",
        category = "Non Kopi",
        price = 30000,
        image = R.drawable.cookies_cream,
        description = "Minuman blended dengan cookies dan krim"
    ),

    Product(
        id = 17,
        name = "Red Velvet Milkshake",
        category = "Non Kopi",
        price = 30000,
        image = R.drawable.redvelvet_milkshake,
        description = "Milkshake red velvet yang creamy dan lembut"
    ),

    Product(
        id = 18,
        name = "Mango Pomelo",
        category = "Non Kopi",
        price = 29000,
        image = R.drawable.mango_pomelo,
        description = "Minuman mangga segar dengan pomelo"
    ),

    // Kategori Camilan

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
    ),

    Product(
        id = 11,
        name = "Dimsum",
        category = "Camilan",
        price = 20000,
        image = R.drawable.dimsum,
        description = "Dimsum ayam lembut dengan saus pilihan"
    ),

    Product(
        id = 12,
        name = "Cireng",
        category = "Camilan",
        price = 15000,
        image = R.drawable.cireng,
        description = "Cireng renyah dengan sambal rujak"
    )
)
