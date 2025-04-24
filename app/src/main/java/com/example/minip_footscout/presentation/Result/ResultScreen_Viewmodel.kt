package com.example.minip_footscout.presentation.Result

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.minip_footscout.data.local.entity.Player
import com.example.minip_footscout.data.local.repository.playerrepository
import com.example.minip_footscout.data.network.Entity.PlayerRequest
import com.example.minip_footscout.data.network.repository.NetworkPlayerRepository
import com.example.minip_footscout.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ResultScreen_Viewmodel @Inject constructor(private val savedStateHandle: SavedStateHandle,private val repository: NetworkPlayerRepository,private val localrepo:playerrepository):ViewModel() {


    private var _ResutScreenState = MutableStateFlow(Result_State())
    val ResultScreenState:StateFlow<Result_State> = _ResutScreenState

    init {

    }
    fun action(events: ResultScreenEvents) {
        when (events) {
            is ResultScreenEvents.getrecommendaton -> {
                viewModelScope.launch(Dispatchers.IO) {
                    localrepo.getplayerbyid(events.id).flowOn(Dispatchers.IO).collectLatest { result ->
                        when (result) {
                            is NetworkResult.Success -> {
                                val player = result.data
                                _ResutScreenState.value=_ResutScreenState.value.copy(playername = player.name)
                                repository.RecommendPlayers(PlayerRequest(player.name))
                                    .flowOn(Dispatchers.IO)
                                    .collectLatest { recommendationResult ->
                                        when (recommendationResult) {
                                            is NetworkResult.Success -> {
                                                val sortedList = recommendationResult.data.sortedByDescending { it.similarity_score }
                                                _ResutScreenState.value = _ResutScreenState.value.copy(
                                                    topplayer = sortedList.take(5),
                                                    nextplayer = sortedList.drop(5)
                                                )
                                            }

                                            is NetworkResult.Error -> {
                                                // handle error properly
                                            }

                                            is NetworkResult.loading -> {
                                                // show loading state
                                            }
                                        }
                                    }
                            }

                            is NetworkResult.Error -> {
                                // handle error properly
                            }

                            is NetworkResult.loading -> {
                                // show loading state
                            }
                        }
                    }
                }
            }
        }
    }


}