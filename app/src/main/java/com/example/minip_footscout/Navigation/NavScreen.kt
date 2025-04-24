package com.example.minip_footscout.Navigation

import com.example.minip_footscout.data.local.entity.Player
import kotlinx.serialization.Serializable

@Serializable
sealed class NavScreen() {
    @Serializable
    object PlayerRecscreen : NavScreen()

    @Serializable
    data class ResultScreen(val id: Int) :NavScreen()

}