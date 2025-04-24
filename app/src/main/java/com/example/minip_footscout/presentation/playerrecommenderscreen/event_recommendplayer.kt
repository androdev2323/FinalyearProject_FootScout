package com.example.minip_footscout.presentation.playerrecommenderscreen

import androidx.compose.ui.text.input.TextFieldValue

sealed class event_recommendplayer {
    data class onquerychange(val query:TextFieldValue): event_recommendplayer()


}