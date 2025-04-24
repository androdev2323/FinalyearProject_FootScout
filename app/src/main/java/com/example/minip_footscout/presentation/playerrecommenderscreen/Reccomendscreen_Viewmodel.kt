package com.example.minip_footscout.presentation.playerrecommenderscreen

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

    fun action(event: event_recommendplayer){
  when(event){
      is event_recommendplayer.onquerychange -> {
          viewModelScope.launch {
              _Screenstate.value=_Screenstate.value.copy(query = event.query)
              val currquery=event.query.text
              if(currquery.isNotBlank()) {
                search(event.query.text)


              }
              else{
                  _Screenstate.value=_Screenstate.value.copy(empty = true)
              }

          }
      }
  }
    }

    fun search(query:String) {
        viewModelScope.launch {
            playerrepository.searchplayers(query).collect() {

                when (it) {
                    is NetworkResult.Success -> {
                        if (!it.data.isEmpty()) {
                            _Screenstate.value = _Screenstate.value.copy(searchlist = it.data)
                        } else {
                            _Screenstate.value = _Screenstate.value.copy(empty = true)
                        }
                    }

                    is NetworkResult.Error -> _Screenstate.value =
                        _Screenstate.value.copy(error = true)

                    is NetworkResult.loading -> {}
                }
            }
        }
    }
}