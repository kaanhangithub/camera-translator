package com.binarystudios.cameratranslator.presentation.languageselection.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.binarystudios.cameratranslator.presentation.common.TopBarTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSelectionTopBar(
    modifier: Modifier = Modifier,
    searchVisible: Boolean,
    searchQuery: String,
    onSearchPressed: () -> Unit,
    onBackPressed: () -> Unit,
    onSearchQueryChanged: (String) -> Unit,
) {
    val focusRequester = remember { FocusRequester() }

    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = ""
                )
            }
        },
        actions = {
            IconButton(onClick = {
                onSearchPressed()
            }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = ""
                )
            }
        },
        title = {
            if (searchVisible) {
                TextField(
                    value = searchQuery,
                    onValueChange = {
                        onSearchQueryChanged(it)
                    },
                    textStyle = MaterialTheme.typography.bodyMedium,
                    placeholder = {
                        Text(
                            color = Color.DarkGray,
                            style = MaterialTheme.typography.bodyMedium,
                            text = "Translate from.."
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        disabledContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color.Black,
                        selectionColors = TextSelectionColors(Color.Transparent, Color.Transparent),
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                        .focusRequester(focusRequester)
                )
                LaunchedEffect(Unit) {
                    focusRequester.requestFocus() // Request focus when the search is visible
                }
            } else {
                TopBarTitle(
                    title = "Select Language"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )
    )
}

@Preview(showBackground = true)
@Composable
private fun LanguageTopBar() {
    LanguageSelectionTopBar(
        searchQuery = "",
        searchVisible = false,
        onSearchPressed = {},
        onBackPressed = {},
        onSearchQueryChanged = {})
}