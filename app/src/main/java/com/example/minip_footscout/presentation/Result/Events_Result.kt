package com.example.minip_footscout.presentation.Result

import com.example.minip_footscout.data.local.entity.Player

sealed class ResultScreenEvents{
    data class getrecommendaton( val id:Int):ResultScreenEvents()
}