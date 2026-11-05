package com.example.kakuchnia.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.kakuchnia.ui.theme.KaKuchniaTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column (modifier = modifier) {
        Text(
            text = "Witaj w KaKuchnia!\n",
            fontSize = 30.sp,
        )
        Text(
            text = "Co dzisiaj ugotujemy??",
            fontSize = 20.sp,
        )
    }
}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    KaKuchniaTheme {
        HomeScreen()
    }
}