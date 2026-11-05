package com.example.kakuchnia.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.kakuchnia.ui.theme.KaKuchniaTheme

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    Column (modifier = modifier) {
        Text(
            text = "This will be the recipe addition screen\n",
            fontSize = 30.sp,
        )
    }
}



@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    KaKuchniaTheme {
        HomeScreen()
    }
}