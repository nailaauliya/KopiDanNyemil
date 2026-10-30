package lat.pam.kopidannyemil.model

import lat.pam.kopidannyemil.R

data class Product(
    val id: Int,
    val name: String,
    val category: String,
    val price: Int,
    val image: Int
)

val dummyProducts = listOf(
    Product(
        1, "Kopi Susu Gula Aren",
        "Kopi", 23000, R.drawable.kopi_susu
    ),
    Product(
        2, "Cappuccino",
        "Kopi", 25000, R.drawable.cappuccino
    ),
    Product(
        3, "Matcha Latte",
        "Non Kopi", 27000, R.drawable.matcha_latte
    ),
    Product(
        4, "Donat Cokelat",
        "Camilan", 16000, R.drawable.donat_cokelat
    ),
    Product(
        5, "Butter Croissant",
        "Camilan", 22000, R.drawable.croissant
    ),
    Product(
        6, "Choco Cookies",
        "Camilan", 15000, R.drawable.cookies
    )
)
