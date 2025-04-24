package com.example.minip_footscout.presentation.Result

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.minip_footscout.AppTheme
import com.example.minip_footscout.data.local.entity.Player
import com.example.minip_footscout.presentation.Result.components.OtherMatches
import com.example.minip_footscout.presentation.Result.components.Player_Result_horizontalcard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen( id:Int) {
val viewmodel:ResultScreen_Viewmodel= hiltViewModel()
    val state=viewmodel.ResultScreenState.collectAsState()
   LaunchedEffect(key1 = id) {
     viewmodel.action(ResultScreenEvents.getrecommendaton(id))
   }

    Scaffold(
        topBar = {
            TopAppBar(title = {
            Text(
                "Players Simillar to ${state.value.playername}",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
        },
                colors = TopAppBarDefaults.topAppBarColors().copy(containerColor = MaterialTheme.colorScheme.surfaceContainer, titleContentColor = MaterialTheme.colorScheme.onSurface)
            )
        })
    { padding ->

        LazyColumn(modifier = Modifier
            .padding(paddingValues = padding)
            .padding(13.dp)) {
            item {
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Top Matches", style = MaterialTheme.typography.titleLarge)
            }
            item {
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(state.value.topplayer) {
                        println(state.value.topplayer)
                        if (it.League == "Premier League") {
                            Player_Result_horizontalcard(
                                playerResponse = it,
                                color = Color(0xFF3D195B)
                            )
                        } else if (it.League == "Serie A") {
                            Player_Result_horizontalcard(
                                playerResponse = it,
                                color = Color(0xFF008fd7)
                            )
                        } else if (it.League == "Ligue 1") {
                            Player_Result_horizontalcard(
                                playerResponse = it,
                                color = Color(0xFF091C3E)
                            )
                        } else if (it.League == "Bundesliga") {
                            Player_Result_horizontalcard(
                                playerResponse = it,
                                color = Color(0xFFd20515)
                            )
                        } else if (it.League == "La Liga") {
                            Player_Result_horizontalcard(
                                playerResponse = it,
                                color = Color(0xFFff7676)
                            )
                        } else {
                            Player_Result_horizontalcard(
                                playerResponse = it,
                                color = Color(0xFF666)
                            )
                        }
                    }


                }
            }
            item {
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Other Simillar Players",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
            }


                    items(state.value.nextplayer) {

                        if (it.League == "Premier League") {
                            OtherMatches(playerResponse = it, color = Color(0xFF3D195B))
                        } else if (it.League == "Serie A") {
                            OtherMatches(playerResponse = it, color = Color(0xFF008fd7))
                        } else if (it.League == "Ligue 1") {
                            OtherMatches(playerResponse = it, color = Color(0xFF091C3E))
                        } else if (it.League == "Bundesliga") {
                            OtherMatches(playerResponse = it, color = Color(0xFFd20515))
                        } else if (it.League == "La Liga") {
                            OtherMatches(playerResponse = it, color = Color(0xFFff7676))
                        } else {
                            OtherMatches(playerResponse = it, color = Color(0xFF666))
                        }
                    }
                }
            }

            }




@Preview(showBackground = true,)
@Composable
private fun ResultScreenPreview() {
    MaterialTheme{
    ResultScreen(id = 2)
        }
}





