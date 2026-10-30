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

    // FOTO PROFIL PENGGUNA
    var profilePhotoUri by remember {
        mutableStateOf<Uri?>(null)
    }

    // KERANJANG BELANJA
    val quantities = remember {
        mutableStateMapOf<Int, Int>()
    }

    val totalItems = quantities.values.sum()

    val totalPrice = dummyProducts.sumOf { product ->
        product.price * (quantities[product.id] ?: 0)
    }

    // DATA PENGIRIMAN
    var recipient by remember {
        mutableStateOf("")
    }

    var phone by remember {
        mutableStateOf("")
    }

    var address by remember {
        mutableStateOf("")
    }

    var notes by remember {
        mutableStateOf("")
    }

    // DATA PESANAN FINAL
    var confirmedItems by remember {
        mutableIntStateOf(0)
    }

    var confirmedPrice by remember {
        mutableIntStateOf(0)
    }

    // FUNGSI TAMBAH PRODUK
    val addProduct: (Int) -> Unit = { productId ->
        quantities[productId] =
            (quantities[productId] ?: 0) + 1
    }

    // FUNGSI KURANG PRODUK
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
            "home" -> "signup"
            "profile", "cart" -> "home"
            "order" -> "cart"
            "confirmation" -> "confirmation"
            else -> "welcome"
        }
    }

    // NAVIGASI HALAMAN
    when (currentScreen) {

        // 01 - WELCOME
        "welcome" -> WelcomeScreen(
            onStart = {
                currentScreen = "signup"
            }
        )

        // 02 - SIGN UP
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

        // 03 - LOGIN
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

        // 04 - REGISTER
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

        // 05 - HOME
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

        // 06 - PROFILE
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
                currentScreen = "signup"
            }
        )

        // 07 - KERANJANG
        "cart" -> KeranjangScreen(
            quantities = quantities,
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

        // 08 - ALAMAT PENGIRIMAN
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
                currentScreen = "confirmation"
            }
        )

        // 09 - KONFIRMASI
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
