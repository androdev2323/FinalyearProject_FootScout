package com.example.minip_footscout.data.network.Entity

import com.example.minip_footscout.data.local.entity.Player
import com.example.minip_footscout.data.network.PlayerResutapi
import com.example.minip_footscout.data.network.repository.NetworkPlayerRepository
import com.example.minip_footscout.util.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class NetworkPlayerRepositoryImpl @Inject constructor(val playerresutapi:PlayerResutapi):NetworkPlayerRepository{
    override suspend fun RecommendPlayers(player: PlayerRequest): Flow<NetworkResult<List<PlayerResponse>>> {
    return flow {
        emit(NetworkResult.loading)
         val result=playerresutapi.recommndedplayers(player)
        if(result.isSuccessful){
            emit(NetworkResult.Success(result.body()!!))
        }
        else{
            emit(NetworkResult.Error(error=result.message()))
        }
    }
    }

}