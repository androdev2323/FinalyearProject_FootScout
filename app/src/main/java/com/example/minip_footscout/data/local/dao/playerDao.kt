package com.example.minip_footscout.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.minip_footscout.data.local.entity.Player
import kotlinx.coroutines.flow.Flow

@Dao
interface playerDao {

    @Query("SELECT * FROM players WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%' ")
    suspend fun searchPlayersbyName(query:String): List<Player>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertALL(player: List<Player>)

    @Query("SELECT COUNT(*) FROM players")
    suspend fun getPlayerCount(): Int
}