package com.example.minip_footscout.playerrecommenderscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.minip_footscout.R


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun previewplayercard() {
    ImprovedPlayerCard()
}
@Composable
fun playercard() {
    Card(onClick = { }, shape = RoundedCornerShape(20.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)) {
        Column(modifier = Modifier) {
            Image(
                painter = painterResource(id = R.drawable.sample_image),
                contentScale = ContentScale.FillWidth,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier.fillMaxWidth(), text = "Neymar",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold

            )
            Spacer(modifier = Modifier.height(5.dp))
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                thickness = 2.dp
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 6.dp, top = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Nationality", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                        Text(modifier = Modifier, text = "Brazil",fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp, top = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Age", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = "33")
                    }
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp, top = 20.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "Year")
                        Text(text = "1992")
                    }
                }
                VerticalDivider(
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    thickness = 2.dp
                )
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp, top = 20.dp, start = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Team")

                        Text(modifier = Modifier, text = "Paris Saint")
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp, top = 20.dp, start = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Position")
                        Text(text = "Fw")
                    }
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(end = 20.dp, top = 20.dp, start = 5.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "Nationality", style = MaterialTheme.typography.bodySmall.copy(fontSize = 15.sp))
                        Text(text = "Brazil", style = MaterialTheme.typography.bodySmall.copy(fontSize = 20.sp))
                    }
                }
            }
        }
    }

}



@Composable
fun ImprovedPlayerCard() {
    Card(
        onClick = { },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sample_image),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Player Image",
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.3f))
                )
                Text(
                    text = "Neymar",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                PlayerInfoColumn(
                    listOf(
                        "Nationality" to "Brazil",
                        "Age" to "33",
                        "Year" to "1992"
                    )
                )
                VerticalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))
                PlayerInfoColumn(
                    listOf(
                        "Team" to "Paris Saint",
                        "Position" to "FW",
                        "League" to "Ligue 1"
                    )
                )
            }
        }
    }
}

@Composable
fun PlayerInfoColumn(infoList: List<Pair<String, String>>) {
    Column {
        infoList.forEach { (label, value) ->
            PlayerInfoRow(label, value)
            if (infoList.last() != (label to value)) {
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun PlayerInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}
