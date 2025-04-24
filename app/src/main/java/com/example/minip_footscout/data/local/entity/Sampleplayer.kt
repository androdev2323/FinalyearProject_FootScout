package com.example.minip_footscout.data.local.entity

import kotlinx.serialization.Serializable

@Serializable
data class Sampleplayer(val name :String, val image:Int,
                        val birth:String, val position :String, val age :Int, val league:String, val nation:String )
