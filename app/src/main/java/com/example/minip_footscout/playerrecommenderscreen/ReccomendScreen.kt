package com.example.minip_footscout.playerrecommenderscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.minip_footscout.playerrecommenderscreen.components.searchBar


@Composable
fun playerscreen(viewmodel: Reccomendscreen_Viewmodel = hiltViewModel(),modifier: Modifier=Modifier){
val state=viewmodel.Screenstate.value
Scaffold(
     topBar = {}
){
   searchBar(query = "", onValueChange = ) {
        
   }  
}
     

