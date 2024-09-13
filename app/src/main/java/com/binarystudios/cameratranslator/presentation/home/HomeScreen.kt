package com.binarystudios.cameratranslator.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.binarystudios.cameratranslator.presentation.common.LanguageSelector
import com.binarystudios.cameratranslator.presentation.TranslateViewModel
import com.binarystudios.cameratranslator.presentation.home.components.EditTextCard
import com.binarystudios.cameratranslator.ui.theme.CameraTranslator_NewTheme

@Composable
fun HomeScreen(
    navController: NavController?,
    viewModel: TranslateViewModel?,
    contentPadding: PaddingValues
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var isTextFieldFocused by remember { mutableStateOf(false) } // Track focus state
    val editText = viewModel?.translateFromText?.value ?: ""
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val containerHeight = screenHeight * 10 / 16
    val translateFrom = viewModel?.translateFrom?.value
    val translateTo = viewModel?.translateTo?.value

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(
                top = contentPadding.calculateTopPadding(),
                bottom = contentPadding.calculateBottomPadding()
            )
            .fillMaxSize()
    ) {
        EditTextCard(
            label = if (isTextFieldFocused) translateFrom?.name ?: "English" else "Enter Text",
            editText = editText,
            containerHeight = containerHeight,
            onClearTextClicked = { viewModel?.setTranslateFromText("") },
            onValueChange = { viewModel?.setTranslateFromText(it) },
            onDoneClicked = {
                keyboardController?.hide() // Hide the keyboard when 'Enter' is pressed
                // Navigate to the next screen when Enter is pressed
                if (editText.isNotEmpty()) {
                    navController?.navigate("Translation/${editText}") // Change this to your destination route
                    viewModel?.setTranslateFromText("")
                }
            },
            onFocusChanged = { isTextFieldFocused = it }
        )

        LanguageSelector(
            translateFrom = translateFrom?.name ?: "English",
            translateTo = translateTo?.name ?: "Turkish",
            onTranslateFromClicked = {
                navController?.navigate("LanguageSelection/${true}")
            },
            onTranslateToClicked = {
                navController?.navigate("LanguageSelection/${false}")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePrev() {
    CameraTranslator_NewTheme {
        HomeScreen(
            navController = null, viewModel = null, contentPadding = PaddingValues(
                all = 16.dp
            )
        )
    }

}