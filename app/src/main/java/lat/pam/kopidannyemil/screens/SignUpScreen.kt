package lat.pam.kopidannyemil.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import lat.pam.kopidannyemil.R
import lat.pam.kopidannyemil.components.CoffeeButton
import lat.pam.kopidannyemil.design.Cream
import lat.pam.kopidannyemil.design.Espresso
import lat.pam.kopidannyemil.design.MutedBrown
import lat.pam.kopidannyemil.design.White

@Composable
fun SignUpScreen(
    onBack: () -> Unit,
    onLogin: () -> Unit,
    onRegister: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 26.dp)
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        // HEADER
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = onBack,
                modifier = Modifier.size(40.dp)
            ) {
                Text(
                    text = "←",
                    fontSize = 25.sp,
                    color = Espresso
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "KOPI DAN NYEMIL",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp,
                color = Espresso
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // FOTO KOPI DAN CAMILAN
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(245.dp)
                .clip(RoundedCornerShape(22.dp))
        ) {

            Image(
                painter = painterResource(
                    R.drawable.coffee_signup
                ),
                contentDescription = "Kopi dan camilan",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // GRADIENT FOTO
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Espresso.copy(alpha = 0.72f)
                            )
                        )
                    )
            )

            Text(
                text = "A little coffee,\na lot of happiness.",
                fontSize = 23.sp,
                lineHeight = 28.sp,
                fontWeight = FontWeight.Bold,
                color = White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(20.dp)
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        // JUDUL
        Text(
            text = "Selamat Datang!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Espresso
        )

        Spacer(modifier = Modifier.height(10.dp))

        // DESKRIPSI
        Text(
            text = "Gabung dan temukan berbagai pilihan " +
                    "kopi serta camilan favorit untuk menemani harimu.",
            fontSize = 14.sp,
            lineHeight = 22.sp,
            color = MutedBrown
        )

        Spacer(modifier = Modifier.height(26.dp))

        // TOMBOL REGISTER
        CoffeeButton(
            text = "Daftar Sekarang  →",
            onClick = onRegister
        )

        Spacer(modifier = Modifier.height(12.dp))

        // TOMBOL LOGIN
        CoffeeButton(
            text = "Sudah Punya Akun? Masuk",
            onClick = onLogin,
            outlined = true
        )

        Spacer(modifier = Modifier.height(26.dp))

        // FOOTER
        Text(
            text = "Made for your coffee moments.",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 11.sp,
            color = MutedBrown
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

// PREVIEW SIGN UP

@Preview(
    name = "02 - Sign Up",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SignUpScreenPreview() {
    MaterialTheme {
        SignUpScreen(
            onBack = {},
            onLogin = {},
            onRegister = {}
        )
    }
}
