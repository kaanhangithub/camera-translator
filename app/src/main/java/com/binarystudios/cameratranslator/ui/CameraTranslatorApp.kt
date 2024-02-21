package com.binarystudios.cameratranslator.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.binarystudios.cameratranslator.common.Navigation

@Composable
fun CameraTranslatorApp() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {},
        bottomBar = {},
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Navigation(navHostController = navController, contentPaddingValues = it)
        }
    }
}