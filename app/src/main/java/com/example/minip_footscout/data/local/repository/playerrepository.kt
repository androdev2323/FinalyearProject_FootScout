package com.example.minip_footscout.data.local.repository

import android.content.Context
import com.example.minip_footscout.data.local.entity.Player
import com.example.minip_footscout.util.NetworkResult
import kotlinx.coroutines.flow.Flow

interface playerrepository {
   suspend fun insertALL(player:List<Player>)
   suspend fun searchplayers(query:String): Flow<NetworkResult<List<Player>>>
   suspend fun importPlayersFromCsvIfNeeded()

}