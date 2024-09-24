package com.example.minip_footscout.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.minip_footscout.data.local.dao.playerDao
import com.example.minip_footscout.data.local.entity.Player

@Database(entities = [Player::class], version = 1)
abstract class PlayerDatabase : RoomDatabase() {
    abstract fun playerDao():playerDao
}