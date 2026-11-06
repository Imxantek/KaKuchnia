package com.example.kakuchnia.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kakuchnia.ui.theme.KaKuchniaTheme

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
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
                .fillMaxSize()
                .background(Color.LightGray)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Motyw:",
                    fontSize = 30.sp,
                    modifier = modifier.weight(1f)
                )

                Text(
                    text = "Jasny",
                    fontSize = 30.sp,
                )
            }

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Rozmiar tekstu:",
                    fontSize = 30.sp,
                    modifier = modifier.weight(1f)
                )

                Text(
                    text = "Zwykły",
                    fontSize = 30.sp,
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