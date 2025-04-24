package com.example.minip_footscout.DI

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.minip_footscout.data.local.dao.playerDao
import com.example.minip_footscout.data.local.database.PlayerDatabase
import com.example.minip_footscout.data.local.entity.Player
import com.example.minip_footscout.data.local.entity.playerrepoImpl
import com.example.minip_footscout.data.local.repository.playerrepository
import com.example.minip_footscout.data.network.Entity.NetworkPlayerRepositoryImpl
import com.example.minip_footscout.data.network.PlayerResutapi
import com.example.minip_footscout.data.network.repository.NetworkPlayerRepository
import com.example.minip_footscout.database.databasehelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object appmodule {
    @Provides
    @Singleton()
    fun provideDatabase(@ApplicationContext app: Context): PlayerDatabase {
        return Room.databaseBuilder(
            app,
            PlayerDatabase::class.java,
            "players"
        ).build()
    }

    @Provides
    fun providePlayerDao(db: PlayerDatabase): playerDao {
        return db.playerDao()
    }

    @Provides
    fun providesplayerrepository(
        dao: playerDao,
        @ApplicationContext context: Context
    ): playerrepository {
        return playerrepoImpl(dao, context)
    }

    @Provides
    @Singleton
    fun providesretroditclient():Retrofit {
        return Retrofit.Builder().baseUrl("https://footscoutdl.onrender.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesPlayerResultApi(retrofit: Retrofit): PlayerResutapi {
        return retrofit.create(PlayerResutapi::class.java)
    }

    @Provides
    fun providesPlayerResultRepo(playerresultapi: PlayerResutapi): NetworkPlayerRepository {
        return NetworkPlayerRepositoryImpl(playerresultapi)
    }

}

