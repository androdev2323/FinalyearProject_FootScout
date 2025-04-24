package com.example.minip_footscout.presentation.Result.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.minip_footscout.R
import com.example.minip_footscout.data.network.Entity.PlayerResponse

@Composable
fun OtherMatches(modifier: Modifier = Modifier, playerResponse: PlayerResponse, color: Color) {
    Card(
        modifier
            .height(280.dp)
            .fillMaxWidth(0.97f)
            .padding(10.dp),
        shape = RoundedCornerShape(size = 15.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(modifier = modifier) {
            Image(
                painter = rememberAsyncImagePainter(model = playerResponse.image_url),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize()
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
                    Row(
                        modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = playerResponse.Player,
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.White
                        )
                        Row(
                            modifier
                                .padding(start = 5.dp)
                                .wrapContentSize()
                                .background(Color.White.copy(alpha = 0.2f))
                        ) {
                            Text(
                                modifier = modifier.padding(3.dp),
                                text = "FW",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.White
                            )
                        }
                    }


                    Spacer(modifier = modifier.height(5.dp))


                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            modifier = modifier.height(MaterialTheme.typography.bodySmall.fontSize.value.dp * 1.5f),
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
                    Spacer(modifier = modifier.height(20.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            modifier = modifier
                                .wrapContentSize()
                                .background(color = color.copy(alpha = 0.8f)),

                            ) {
                            Text(
                                modifier = modifier.padding(5.dp),
                                text = playerResponse.League,
                                minLines = 1,
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.White
                            )
                        }

                        Column {
                            val text = String.format("%.2f", playerResponse.similarity_score * 100)
                            Text(text = "${text} Simillar ")
                            Row(
                                Modifier
                                    .fillMaxWidth(0.6f)
                                    .background(Color.Black)
                            ) {
                                LinearProgressIndicator(
                                    modifier = Modifier.fillMaxWidth(),
                                    progress = { (text.toFloat() / 100) },
                                    color = Color.Green,
                                    strokeCap = StrokeCap.Round,
                                    trackColor = Color.Gray)

                            }

                        }
                    }


                }

            }


        }
    }
}


@Preview
@Composable
private fun Other_Matches_Preview() {
    MaterialTheme {
        OtherMatches(
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

