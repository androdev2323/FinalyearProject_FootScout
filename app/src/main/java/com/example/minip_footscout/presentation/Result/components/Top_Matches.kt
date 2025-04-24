package com.example.minip_footscout.presentation.Result.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.minip_footscout.R
import com.example.minip_footscout.data.network.Entity.PlayerResponse

@Composable
fun Player_Result_horizontalcard(
    modifier: Modifier = Modifier,
    playerResponse: PlayerResponse,
    color: Color
) {
    Card(
        modifier
            .height(280.dp)
            .width(400.dp)
            .padding(start = 30.dp),
        shape = RoundedCornerShape(size = 5.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(modifier = modifier) {
            AsyncImage(
                model = playerResponse.image_url,
                contentDescription = "",
                modifier.fillMaxSize(),
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.3f)
                            )
                        )
                    )
            )
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .padding(8.dp), contentAlignment = Alignment.BottomStart
            ) {
                Column {
                    Text(
                        modifier = modifier,
                        text = playerResponse.Player,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                    Spacer(modifier = modifier.height(5.dp))
                    Row(
                        modifier
                            .fillMaxWidth()
                            .background(Color.White.copy(alpha = 0.2f))
                    ) {
                        Text(
                            text = playerResponse.Position,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = modifier.height(5.dp))
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = modifier.height(MaterialTheme.typography.bodySmall.fontSize.value.dp),
                            painter = painterResource(id = R.drawable.football),
                            contentDescription = ""
                        )
                        Text(
                            modifier = modifier.padding(start = 3.dp),
                            text = playerResponse.Squad,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White
                        )
                        Spacer(modifier = modifier.width(20.dp))
                        Text(
                            text = playerResponse.Age.toString() + " " + "yrs",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White
                        )


                    }
                    Spacer(modifier = modifier.height(30.dp))
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .background(color = color.copy(alpha = 0.8f))
                    ) {
                        Text(
                            text = playerResponse.League,
                            minLines = 1,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.White
                        )
                    }


                }


            }
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.TopEnd) {
                PercentageChip(text = (playerResponse.similarity_score * 100))
            }
        }
    }
}

@Preview
@Composable
private fun Preview_Player_Result_horizontal() {
    MaterialTheme {
        Player_Result_horizontalcard(
            playerResponse = PlayerResponse(
                Player = "Bernardo Silva",
                "MF",
                "Premier League",
                "Manchester City",
                "POR",
                28,
                0.8988534212112427,
                "https://i2.wp.com/sportytell.com/wp-content/uploads/2019/11/Bernardo-Silva-of-Manchester-City-scaled.jpg?fit=1200,816&ssl=1"
            ), color = Color(0xFF3D195B)
        )
    }
}