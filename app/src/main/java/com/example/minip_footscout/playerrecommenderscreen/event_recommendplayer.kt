package com.example.minip_footscout.playerrecommenderscreen

sealed class event_recommendplayer {
    data class onquerychange(val query:String):event_recommendplayer()

}