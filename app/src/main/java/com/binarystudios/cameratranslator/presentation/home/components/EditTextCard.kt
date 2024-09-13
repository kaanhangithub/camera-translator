package com.binarystudios.cameratranslator.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.binarystudios.cameratranslator.presentation.common.ic_icon_translate

@Composable
fun EditTextCard(
    modifier: Modifier = Modifier,
    label: String,
    editText: String,
    containerHeight: Dp,
    onClearTextClicked: () -> Unit,
    onValueChange: (String) -> Unit,
    onDoneClicked: () -> Unit,
    onFocusChanged: (Boolean) -> Unit
) {
        Card(
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomEnd = 50.dp, // Adjust the radius as needed
                bottomStart = 50.dp // Adjust the radius as needed
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(containerHeight),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xfff9e9e3),
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    label = {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = label,
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color(0xffc5382c)
                            )
                            Spacer(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth()
                            )
                            if (editText.isNotEmpty()) {
                                IconButton(
                                    onClick = onClearTextClicked
                                ) {
                                    Icon(
                                        modifier = Modifier.padding(start = 15.dp),
                                        imageVector = Icons.Filled.Close,
                                        contentDescription = "",
                                        tint = Color(0xffc5382c)
                                    )
                                }
                            }
                        }
                    },
                    textStyle = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        //.fillMaxSize()
                        .weight(6f)
                        .padding(start = 5.dp, end = 5.dp, top = 10.dp)
                        .background(Color.Transparent)
                        .onFocusChanged { focusState ->
                            onFocusChanged(focusState.isFocused)
                        },
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        cursorColor = Color.LightGray,
                        errorCursorColor = Color.LightGray,
                        selectionColors = TextSelectionColors(Color.LightGray, Color.LightGray),
                        focusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    value = editText,
                    onValueChange = {
                        onValueChange(it)
                    },
                    placeholder = {
                        Text(
                            modifier = Modifier.padding(top = 5.dp),
                            text = "Enter Text",
                            fontSize = 15.sp,
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xff6d6b67)
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            onDoneClicked()
                        }
                    )
                )
                if (editText.isNotEmpty()) {
                    Button(
                        modifier = Modifier
                            .weight(1f)
                            .padding(bottom = 5.dp, end = 5.dp)
                            .align(Alignment.End),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        onClick = onDoneClicked
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(20.dp)
                                .padding(end = 5.dp),
                            imageVector = ic_icon_translate,
                            tint = Color(0xffc5382c),
                            contentDescription = "")
                        Text(
                            text = "Translate",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xffc5382c)
                        )
                    }
                }
            }

        }
}

@Preview(showBackground = true)
@Composable
private fun EditTextCardPrev() {
    EditTextCard(
        label = "English",
        editText = "sd",
        containerHeight = 500.dp,
        onClearTextClicked = {},
        onValueChange = {},
        onDoneClicked = {},
        onFocusChanged = {}
    )
}
