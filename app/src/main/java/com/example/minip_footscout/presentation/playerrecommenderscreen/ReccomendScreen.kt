package com.example.minip_footscout.presentation.playerrecommenderscreen

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.minip_footscout.R
import com.example.minip_footscout.data.local.entity.Player
import com.example.minip_footscout.data.local.entity.Sampleplayer
import com.example.minip_footscout.presentation.playerrecommenderscreen.components.ImprovedPlayerCard
import com.example.minip_footscout.presentation.playerrecommenderscreen.components.PlayerListCard
import com.example.minip_footscout.presentation.playerrecommenderscreen.components.playercard
import com.example.minip_footscout.presentation.playerrecommenderscreen.components.searchBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun playerscreen(
    viewmodel: Reccomendscreen_Viewmodel = hiltViewModel(),
    modifier: Modifier = Modifier,
    onNavigateToResult:(Int) -> Unit
) {
    val state = viewmodel.Screenstate.value
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Player Recommender", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )

        }
    ) {

            paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 2.dp)

        ) {
            SearchBar(
                query = state.query.text,
                onQueryChange = { viewmodel.action(
                    event_recommendplayer.onquerychange(
                        TextFieldValue(it)
                    )
                ) },
                onSearch = { },
                active = false,
                onActiveChange = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                // Search content
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Recommended Players",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .padding(horizontal = 16.dp)
            )

            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
                contentPadding = PaddingValues(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .height(220.dp)
            ) {
                items(state.searchlist) { player ->
                    PlayerListCard(player = player, onClick ={ onNavigateToResult(player.id)})
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Featured Players",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .padding(16.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(vertical = 8.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth().fillMaxHeight()
            ) {
                items(samplePlayers) { player ->
                    ImprovedPlayerCard(player)
                }
            }
        }

    }
}
val samplePlayers = listOf(
Sampleplayer(name = "Lionel Messi", position = "Forward", age = 34, league = "Ligue 1", nation = "Argentina", image = R.drawable.messi, birth = "1987"),
Sampleplayer(name = "Cristiano Ronaldo", position = "Forward", age = 37, league = "Saudi Pro League", nation = "Portugal", image = R.drawable.ronaldo, birth = "1985"),
Sampleplayer(name = "Neymar Jr.", position = "Forward", age = 31, league = "Saudi Pro League", nation = "Brazil", image = R.drawable.sample_image, birth = "1992"),
Sampleplayer(name = "Kylian Mbappé", position = "Forward", age = 24, league = "Ligue 1", nation = "France", image = R.drawable.mbappe, birth = "1998")
)

     

