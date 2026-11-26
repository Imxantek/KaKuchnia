package com.example.kakuchnia.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.kakuchnia.components.Recipe

@Composable
fun RecipeScreen(modifier: Modifier = Modifier, recipe: Recipe? = null) {
    Column (modifier = modifier) {
        Text(
            text = "This will be the individual recipe screen\n",
            fontSize = 30.sp,
        )
    }
}