package com.example.minip_footscout.playerrecommenderscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.minip_footscout.playerrecommenderscreen.components.PlayerListCard
import com.example.minip_footscout.playerrecommenderscreen.components.searchBar


@Composable
fun playerscreen(
    viewmodel: Reccomendscreen_Viewmodel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val state = viewmodel.Screenstate.value
    Scaffold(
        topBar = {
           
           
        }
    ) {

        Column(modifier = Modifier.padding(it)) {
            searchBar(query = state.query,
                onValueChange = { viewmodel.action(event_recommendplayer.onquerychange(it)) },
                onClearClicked = {

                })
            Spacer(modifier = Modifier.height(10.dp))
            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            ) {
                items(state.searchlist) { player ->
                    PlayerListCard(player = player)
                }
            }
        }

    }
}

     

