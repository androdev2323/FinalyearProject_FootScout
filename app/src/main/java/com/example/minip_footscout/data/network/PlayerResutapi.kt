package com.example.minip_footscout.data.network


import com.example.minip_footscout.data.local.entity.Player
import com.example.minip_footscout.data.network.Entity.PlayerRequest
import com.example.minip_footscout.data.network.Entity.PlayerResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PlayerResutapi {
    @POST("find_similar_players")
    suspend fun recommndedplayers(@Body request:PlayerRequest):Response<List<PlayerResponse>>


}