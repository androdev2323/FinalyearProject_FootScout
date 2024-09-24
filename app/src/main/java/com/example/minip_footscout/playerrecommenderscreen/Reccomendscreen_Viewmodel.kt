package com.example.minip_footscout.playerrecommenderscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.minip_footscout.data.local.repository.playerrepository
import com.example.minip_footscout.unspecified_scheme
import com.example.minip_footscout.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Reccomendscreen_Viewmodel @Inject constructor(private val playerrepository: playerrepository ):ViewModel() {
    private var _Screenstate = mutableStateOf(playerRecommendationstate())
    val Screenstate = _Screenstate
    init {
        viewModelScope.launch {
            playerrepository.importPlayersFromCsvIfNeeded()
        }
    }

    fun action(event:event_recommendplayer){
  when(event){
      is event_recommendplayer.onquerychange -> {
          viewModelScope.launch {
              playerrepository.searchplayers(event.query).collect() {
                  when (it) {
                      is NetworkResult.Success -> {
                          _Screenstate.value = _Screenstate.value.copy(searchlist =it.data)
                      }

                      is NetworkResult.Error ->
                      NetworkResult.loading ->
                  }
              }

          }
      }
  }
    }
}