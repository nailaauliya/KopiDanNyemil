package lat.pam.kopidannyemil.navigation

import android.net.Uri
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.*
import lat.pam.kopidannyemil.model.dummyProducts
import lat.pam.kopidannyemil.screens.*

@Composable
fun AppNavigation() {

    // NAVIGASI
    var currentScreen by remember {
        mutableStateOf("welcome")
    }

    // DATA AKUN
    var registeredName by remember {
        mutableStateOf("")
    }

    var registeredUsername by remember {
        mutableStateOf("")
    }

    var registeredPassword by remember {
        mutableStateOf("")
    }

    var loggedInName by remember {
        mutableStateOf("")
    }

    // FOTO PROFIL
    var profilePhotoUri by remember {
        mutableStateOf<Uri?>(null)
    }

    // DATA KERANJANG
    val quantities = remember {
        mutableStateMapOf<Int, Int>()
    }

    val totalItems = quantities.values.sum()

    val totalPrice = dummyProducts.sumOf { product ->
        product.price * (quantities[product.id] ?: 0)
    }

    // RIWAYAT PESANAN
    val riwayatPesanan = remember {
        mutableStateListOf<RiwayatPesanan>()
    }

    // DATA PENGIRIMAN
    var recipient by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    // DATA KONFIRMASI
    var confirmedItems by remember {
        mutableIntStateOf(0)
    }

    var confirmedPrice by remember {
        mutableIntStateOf(0)
    }

    // TAMBAH PRODUK
    val addProduct: (Int) -> Unit = { productId ->
        quantities[productId] =
            (quantities[productId] ?: 0) + 1
    }

    // KURANG PRODUK
    val removeProduct: (Int) -> Unit = { productId ->
        val current = quantities[productId] ?: 0

        if (current > 1) {
            quantities[productId] = current - 1
        } else {
            quantities.remove(productId)
        }
    }

    // TOMBOL BACK ANDROID
    BackHandler(enabled = currentScreen != "welcome") {
        currentScreen = when (currentScreen) {
            "signup" -> "welcome"
            "login", "register" -> "signup"
            "profile", "cart" -> "home"
            "order" -> "cart"
            "confirmation" -> "confirmation"
            "home" -> "home"
            else -> "welcome"
        }
    }

    when (currentScreen) {

        // WELCOME
        "welcome" -> WelcomeScreen(
            onStart = {
                currentScreen = "signup"
            }
        )

        // SIGN UP
        "signup" -> SignUpScreen(
            onBack = {
                currentScreen = "welcome"
            },
            onLogin = {
                currentScreen = "login"
            },
            onRegister = {
                currentScreen = "register"
            }
        )

        // LOGIN
        "login" -> LoginScreen(
            registeredUsername = registeredUsername,
            registeredPassword = registeredPassword,
            onBack = {
                currentScreen = "signup"
            },
            onRegister = {
                currentScreen = "register"
            },
            onLoginSuccess = {
                loggedInName = registeredName
                currentScreen = "home"
            }
        )

        // REGISTER
        "register" -> RegisterScreen(
            onBack = {
                currentScreen = "signup"
            },
            onLogin = {
                currentScreen = "login"
            },
            onRegisterSuccess = { name, username, password ->
                registeredName = name
                registeredUsername = username
                registeredPassword = password
                profilePhotoUri = null
                currentScreen = "login"
            }
        )

        // HOME
        "home" -> HomeScreen(
            name = loggedInName,
            quantities = quantities,
            onAdd = addProduct,
            onRemove = removeProduct,
            onOrder = {
                currentScreen = "cart"
            },
            onProfile = {
                currentScreen = "profile"
            }
        )

        // PROFILE
        "profile" -> ProfileScreen(
            name = loggedInName,
            username = registeredUsername,
            photoUri = profilePhotoUri,
            onPhotoChange = { uri ->
                profilePhotoUri = uri
            },
            onSave = { newName ->
                loggedInName = newName
                registeredName = newName
            },
            onBack = {
                currentScreen = "home"
            },
            onLogout = {
                loggedInName = ""
                quantities.clear()
                profilePhotoUri = null
                riwayatPesanan.clear()
                currentScreen = "signup"
            }
        )

        // PESANAN: KERANJANG + RIWAYAT
        "cart" -> PesananScreen(
            quantities = quantities,
            riwayat = riwayatPesanan,
            onAdd = addProduct,
            onRemove = removeProduct,
            onBack = {
                currentScreen = "home"
            },
            onCheckout = {
                if (totalItems > 0) {
                    currentScreen = "order"
                }
            }
        )

        // ALAMAT PENGIRIMAN
        "order" -> AlamatScreen(
            name = loggedInName,
            totalItems = totalItems,
            totalPrice = totalPrice,
            onBack = {
                currentScreen = "cart"
            },
            onConfirm = { newRecipient,
                          newPhone,
                          newAddress,
                          newNotes ->

                recipient = newRecipient
                phone = newPhone
                address = newAddress
                notes = newNotes

                confirmedItems = totalItems
                confirmedPrice = totalPrice

                val produkDipesan = dummyProducts.mapNotNull { product ->
                    val jumlah = quantities[product.id] ?: 0

                    if (jumlah > 0) {
                        ItemRiwayat(
                            nama = product.name,
                            jumlah = jumlah,
                            harga = product.price
                        )
                    } else {
                        null
                    }
                }

                if (produkDipesan.isNotEmpty()) {
                    riwayatPesanan.add(
                        RiwayatPesanan(
                            nomor = riwayatPesanan.size + 1,
                            penerima = newRecipient,
                            produk = produkDipesan,
                            totalHarga = confirmedPrice
                        )
                    )
                }

                currentScreen = "confirmation"
            }
        )

        // KONFIRMASI PESANAN
        "confirmation" -> KonfirmasiScreen(
            recipient = recipient,
            totalItems = confirmedItems,
            totalPrice = confirmedPrice,
            onHome = {
                quantities.clear()
                confirmedItems = 0
                confirmedPrice = 0
                currentScreen = "home"
            }
        )
    }
}
