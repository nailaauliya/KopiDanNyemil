package lat.pam.kopidannyemil.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import lat.pam.kopidannyemil.R
import lat.pam.kopidannyemil.design.Espresso
import lat.pam.kopidannyemil.design.MutedBrown

@Composable
fun AuthHeader(
    title: String,
    subtitle: String,
    onBack: () -> Unit
) {
    Column {
        IconButton(onClick = onBack) {
            Text(
                text = "←",
                fontSize = 26.sp,
                color = Espresso
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .size(78.dp)
                .clip(RoundedCornerShape(22.dp))
                .background(Color(0xFFF0E7DA)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.logo_kopi),
                contentDescription = "Logo Kopi dan Nyemil",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(68.dp)
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = title,
            fontSize = 30.sp,
            lineHeight = 37.sp,
            fontWeight = FontWeight.Bold,
            color = Espresso
        )

        Spacer(modifier = Modifier.height(9.dp))

        Text(
            text = subtitle,
            fontSize = 14.sp,
            lineHeight = 22.sp,
            color = MutedBrown
        )
    }
}
