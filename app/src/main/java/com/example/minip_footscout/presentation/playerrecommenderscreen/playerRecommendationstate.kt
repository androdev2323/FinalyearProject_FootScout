package com.example.minip_footscout.presentation.playerrecommenderscreen

import androidx.compose.ui.text.input.TextFieldValue
import androidx.room.Query
import com.example.minip_footscout.data.local.entity.Player

data class playerRecommendationstate(
    val searchlist:List<Player> = emptyList(),
    val query: TextFieldValue=TextFieldValue(""),
    val error:Boolean=false,
    val empty:Boolean = false,

)