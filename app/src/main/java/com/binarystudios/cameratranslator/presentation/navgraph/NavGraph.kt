package com.binarystudios.cameratranslator.presentation.navgraph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.binarystudios.cameratranslator.presentation.TranslateViewModel
import com.binarystudios.cameratranslator.ui.camera.CameraScreen
import com.binarystudios.cameratranslator.presentation.home.HomeScreen
import com.binarystudios.cameratranslator.presentation.languageselection.LanguageSelectionScreen
import com.binarystudios.cameratranslator.presentation.translation.TranslationScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    contentPaddingValues: PaddingValues,
    translateViewModel: TranslateViewModel
) {

    NavHost(navController = navHostController, startDestination = "Text") {
        composable("Text") {
            HomeScreen(
                navController = navHostController,
                viewModel = translateViewModel,
                contentPadding = contentPaddingValues
            )
        }

        composable("Camera") {
            CameraScreen(contentPadding = contentPaddingValues)
        }

        composable("Bookmark") {
            LanguageSelectionScreen(
                navController = null,
                translateViewModel = null,
                isTranslateFrom = true
            )
        }

        composable(
            route = "Translation/{text}", // Define a route with a string parameter
            arguments = listOf(navArgument("text") { type = NavType.StringType })
        ) { backStackEntry ->
            val text = backStackEntry.arguments?.getString("text") ?: ""
            TranslationScreen(
                navController = navHostController,
                text = text,
                viewModel = translateViewModel
            )
        }

        composable(
            route = "LanguageSelection/{isTranslateFrom}",
            arguments = listOf(navArgument("isTranslateFrom") { type = NavType.BoolType })
        ) { backStackEntry ->
            val isTranslateFrom = backStackEntry.arguments?.getBoolean("isTranslateFrom") ?: true
            LanguageSelectionScreen(
                translateViewModel = translateViewModel,
                navController = navHostController,
                isTranslateFrom = isTranslateFrom
            )
        }
    }
}