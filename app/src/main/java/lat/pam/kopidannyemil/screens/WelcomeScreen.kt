package lat.pam.kopidannyemil.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import lat.pam.kopidannyemil.design.Caramel
import lat.pam.kopidannyemil.design.Cream
import lat.pam.kopidannyemil.design.Espresso
import lat.pam.kopidannyemil.design.MutedBrown
import lat.pam.kopidannyemil.design.White

@Composable
fun WelcomeScreen(
    onStart: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
    ) {

        // Foto background
        Image(
            painter = painterResource(R.drawable.coffee_welcome),
            contentDescription = "Foto kopi",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Gradient foto
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        0f to Espresso.copy(alpha = 0.50f),
                        0.38f to Color.Transparent,
                        1f to Color.Transparent
                    )
                )
        )

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            // Logo dan nama aplikasi di tengah atas
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 72.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .size(76.dp)
                        .clip(CircleShape)
                        .background(Cream),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.logo_kopi),
                        contentDescription = "Logo Kopi dan Nyemil",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(68.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "KOPI DAN NYEMIL",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp,
                    color = White,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "COFFEE & BITES",
                    fontSize = 11.sp,
                    letterSpacing = 2.sp,
                    color = White.copy(alpha = 0.90f),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // Panel welcome
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = 30.dp,
                            topEnd = 30.dp
                        )
                    )
                    .background(Cream)
                    .padding(
                        start = 26.dp,
                        end = 26.dp,
                        top = 28.dp,
                        bottom = 30.dp
                    )
            ) {

                Text(
                    text = "YOUR DAILY COFFEE MOMENT",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.5.sp,
                    color = Caramel
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Good Coffee,\nBetter Moments.",
                    fontSize = 31.sp,
                    lineHeight = 38.sp,
                    fontWeight = FontWeight.Bold,
                    color = Espresso
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Nikmati kopi favorit dan camilan lezat " +
                            "yang siap menemani setiap momenmu.",
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    color = MutedBrown
                )

                Spacer(modifier = Modifier.height(26.dp))

                Button(
                    onClick = onStart,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Espresso,
                        contentColor = White
                    )
                ) {
                    Text(
                        text = "Mulai Sekarang  →",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Preview(
    name = "01 - Welcome",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun WelcomeScreenPreview() {
    MaterialTheme {
        WelcomeScreen(onStart = {})
    }
}
