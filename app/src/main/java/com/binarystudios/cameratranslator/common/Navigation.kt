package com.binarystudios.cameratranslator.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navHostController: NavHostController, contentPaddingValues: PaddingValues) {

    NavHost(navController = navHostController, startDestination = "home" ) {
        composable("home"){

        }
    }

}