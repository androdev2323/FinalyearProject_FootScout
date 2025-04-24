package com.example.minip_footscout.data.network.repository

import com.example.minip_footscout.data.local.entity.Player
import com.example.minip_footscout.data.network.Entity.PlayerRequest
import com.example.minip_footscout.data.network.Entity.PlayerResponse
import com.example.minip_footscout.util.NetworkResult
import kotlinx.coroutines.flow.Flow


interface NetworkPlayerRepository{
    suspend fun RecommendPlayers(player:PlayerRequest): Flow<NetworkResult<List<PlayerResponse>>>

}