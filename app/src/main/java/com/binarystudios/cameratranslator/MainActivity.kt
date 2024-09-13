package com.binarystudios.cameratranslator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.binarystudios.cameratranslator.presentation.CameraTranslatorApp
import com.binarystudios.cameratranslator.ui.theme.CameraTranslator_NewTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            CameraTranslator_NewTheme {
                CameraTranslatorApp()
            }
        }
    }
}