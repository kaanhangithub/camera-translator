package com.binarystudios.cameratranslator.presentation.translation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.binarystudios.cameratranslator.presentation.TranslateViewModel
import com.binarystudios.cameratranslator.presentation.common.BottomInset
import com.binarystudios.cameratranslator.presentation.common.TopInset
import com.binarystudios.cameratranslator.ui.theme.CameraTranslator_NewTheme
import com.binarystudios.cameratranslator.presentation.translation.components.TranslationCard
import com.binarystudios.cameratranslator.presentation.translation.components.TranslationTopBar

@Composable
fun TranslationScreen(
    modifier: Modifier = Modifier,
    navController: NavController?,
    text: String,
    viewModel: TranslateViewModel?
) {
    val translateFrom = viewModel?.translateFrom?.value
    val translateTo = viewModel?.translateTo?.value
    val scrollableState = rememberScrollState()
    TopInset()
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TranslationTopBar(
                onBackPressed = { navController?.popBackStack() }
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 8.dp, end = 8.dp, top = contentPadding.calculateTopPadding())
                .verticalScroll(scrollableState),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            TranslationCard(
                text = text,
                language = translateFrom?.name ?: "English",
                contentColor = Color.Black
            )
            Spacer(modifier = Modifier.height(40.dp))
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 40.dp),
                thickness = 0.5.dp,
                color = Color(0xffc5382c)
            )
            Spacer(modifier = Modifier.height(40.dp))
            TranslationCard(
                text = "Hola",
                language = translateTo?.name ?: "Spanish",
                contentColor = Color(0xffc5382c)
            )
            Spacer(modifier = Modifier.height(16.dp))
            BottomInset()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TranslationPrev() {
    CameraTranslator_NewTheme {
        TranslationScreen(navController = null, text = "Hello", viewModel = null)
    }
}