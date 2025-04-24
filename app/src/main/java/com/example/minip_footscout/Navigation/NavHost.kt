package com.example.minip_footscout.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.minip_footscout.presentation.Result.ResultScreen
import com.example.minip_footscout.presentation.playerrecommenderscreen.playerscreen

@Composable
fun Apphost(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = NavScreen.PlayerRecscreen) {
       composable<NavScreen.PlayerRecscreen>{
           backstackentry->

             playerscreen(onNavigateToResult ={
                 player-> navController.navigate(NavScreen.ResultScreen(player))
             } )
       }
        composable<NavScreen.ResultScreen> { navBackStackEntry ->
         val itemid:NavScreen.ResultScreen=navBackStackEntry.toRoute()
            ResultScreen(itemid.id)

        }



    }
}