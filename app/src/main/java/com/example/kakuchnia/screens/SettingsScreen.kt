package com.example.kakuchnia.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kakuchnia.ui.theme.KaKuchniaTheme

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    var mockupCheck by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Ustawienia",
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth()
        )

        Column(
            modifier = modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(50.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Motyw",
                    fontSize = 30.sp,
                    modifier = Modifier.weight(1f)
                )

                Checkbox(
                    checked = mockupCheck,
                    onCheckedChange = { mockupCheck = it }
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    KaKuchniaTheme {
        SettingsScreen()
    }
}