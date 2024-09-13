package com.binarystudios.cameratranslator.presentation.languageselection

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.binarystudios.cameratranslator.presentation.TranslateViewModel
import com.binarystudios.cameratranslator.presentation.common.BottomInset
import com.binarystudios.cameratranslator.presentation.languageselection.components.LanguageItem
import com.binarystudios.cameratranslator.presentation.languageselection.components.LanguageSelectionTopBar
import com.binarystudios.cameratranslator.ui.theme.CameraTranslator_NewTheme

@Composable
fun LanguageSelectionScreen(
    modifier: Modifier = Modifier,
    translateViewModel: TranslateViewModel?,
    navController: NavController?,
    isTranslateFrom: Boolean
) {
    val languages = translateViewModel?.languageList?.value ?: emptyList()
    val translateLanguage =
        if (isTranslateFrom) translateViewModel?.translateFrom?.value else translateViewModel?.translateTo?.value
    var searchQuery by remember { mutableStateOf("") }
    var searchVisible by remember {
        mutableStateOf(false)
    }

    BackHandler {
        navController?.popBackStack()
        searchVisible = false
        translateViewModel?.resetLanguageList()
    }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            LanguageSelectionTopBar(
                searchQuery = searchQuery,
                searchVisible = searchVisible,
                onSearchPressed = {
                    searchVisible = true
                },
                onSearchQueryChanged = {
                    searchQuery = it
                    translateViewModel?.filterLanguages(searchQuery)
                },
                onBackPressed = {
                    if(!searchVisible) {
                        navController?.popBackStack()
                    }
                    searchVisible = false
                    translateViewModel?.resetLanguageList()
                }
            )
        }
    )
    { contentPadding ->
        contentPadding.calculateBottomPadding()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = contentPadding.calculateTopPadding())
        ) {
            items(languages.size) {
                LanguageItem(
                    language = languages[it],
                    isSelected = languages[it].code == translateLanguage?.code,
                    onClick = {
                        if (isTranslateFrom)
                            translateViewModel?.setTranslateFrom(languages[it])
                        else
                            translateViewModel?.setTranslateTo(languages[it])
                        navController?.popBackStack()
                        if(searchVisible){
                            searchVisible = false
                            translateViewModel?.resetLanguageList()
                        }
                    }
                )
            }
            item {
                BottomInset()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LanguageSelectionPrev() {
    CameraTranslator_NewTheme {
        LanguageSelectionScreen(
            navController = null,
            translateViewModel = null,
            isTranslateFrom = true
        )
    }
}