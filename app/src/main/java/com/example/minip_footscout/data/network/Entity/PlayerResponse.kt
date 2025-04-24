package com.example.minip_footscout.data.network.Entity

import kotlinx.serialization.Serializable


@Serializable
data class PlayerResponse(
    val Player: String,
    val Position: String,
    val League: String,
    val Squad: String,
    val Nation:String,
    val Age:Int,
    val similarity_score: Double,
    val image_url:String
)