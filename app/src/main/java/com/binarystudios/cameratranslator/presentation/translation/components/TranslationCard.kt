package com.binarystudios.cameratranslator.presentation.translation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TranslationCard(
    modifier: Modifier = Modifier,
    text: String,
    language: String,
    contentColor: Color
) {
    Text(
        modifier = modifier.padding(start = 13.dp),
        text = language,
        fontSize = 10.sp,
        color = contentColor,
        fontWeight = FontWeight.Light
    )
    Spacer(modifier = modifier.height(10.dp))
    Text(
        modifier = modifier.padding(horizontal = 13.dp),
        text = text,
        fontSize = 25.sp,
        color = contentColor,
        fontWeight = FontWeight.SemiBold
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(0.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = modifier.padding(0.dp),
            onClick = {
                //todo
            }
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "",
                tint = contentColor,
            )
        }
        Spacer(
            modifier = modifier
                .weight(1f)
                .fillMaxWidth()
        )

        IconButton(onClick = {
            //todo
        }) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "",
                tint = contentColor
            )
        }
    }
}