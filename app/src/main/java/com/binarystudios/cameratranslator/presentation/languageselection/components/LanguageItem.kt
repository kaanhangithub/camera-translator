package com.binarystudios.cameratranslator.presentation.languageselection.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.binarystudios.cameratranslator.presentation.TranslateViewModel

@Composable
fun LanguageItem(
    language: TranslateViewModel.Language,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .height(55.dp),
        onClick = { onClick() },
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color(0xfff9e9e3) else Color.White,
            contentColor = if (isSelected) Color(0xffc5382c) else Color.Black
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Text(
                text = language.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.labelLarge
            )
            if (isSelected) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    tint = Color(0xffc5382c),
                    contentDescription = ""
                )
            }
        }
    }
}
