package com.example.minip_footscout.presentation.Result

import com.example.minip_footscout.data.network.Entity.PlayerResponse

data class Result_State(val topplayer: List<PlayerResponse> = emptyList(),
    val nextplayer:List<PlayerResponse> = emptyList(),
    val playername:String=""
    )



