package com.binarystudios.cameratranslator.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LanguageSelector(
    modifier: Modifier = Modifier,
    translateFrom: String,
    translateTo: String,
    onTranslateFromClicked: () -> Unit,
    onTranslateToClicked: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Button(
            onClick = onTranslateFromClicked,
            shape = RoundedCornerShape(30), // Rounded corners
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xfff9e9e3), // Background color for the button
                contentColor = Color.Black // Text color
            ),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 13.dp, vertical = 10.dp)
                .height(55.dp)
        ) {
            Text(
                text = translateFrom,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xffc5382c)
            )
        }
        IconButton(onClick = { /*TODO animate swap button */ }) {
            Icon(
                imageVector = ic_icon_swap,
                tint = Color(0xffc5382c),
                contentDescription = "Swap Languages",
                modifier = Modifier
                    .size(24.dp)
            )
        }
        Button(
            onClick = onTranslateToClicked,
            shape = RoundedCornerShape(30), // Rounded corners
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xfff9e9e3), // Background color for the button
                contentColor = Color.Black // Text color
            ),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 13.dp, vertical = 10.dp)
                .height(55.dp)
        ) {
            Text(
                text = translateTo,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xffc5382c)
            )
        }
    }
}