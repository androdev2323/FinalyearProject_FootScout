package com.example.minip_footscout.util

sealed class NetworkResult<out R> {
    data class Success<out T>(val data:T):NetworkResult<T>()
    object loading:NetworkResult<Nothing>()
    data class Error(val error:String):NetworkResult<Nothing>()
}