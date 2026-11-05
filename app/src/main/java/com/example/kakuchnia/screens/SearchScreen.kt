package com.example.kakuchnia.screens

import com.example.kakuchnia.R
import com.example.kakuchnia.ui.theme.KaKuchniaTheme

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    var query by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Szukaj...",
            fontSize = 40.sp
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = query,
                onValueChange = { query = it },
                modifier = Modifier.weight(1f)
            )
            IconButton(onClick = { }) {
                Icon(painter = painterResource(id = R.drawable.ic_filters), contentDescription = "Filtry")
            }
            IconButton(onClick = { }) {
                Icon(painter = painterResource(id = R.drawable.ic_sort), contentDescription = "Sortuj")
            }
        }

        LazyColumn {
        }
    }
}



@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    KaKuchniaTheme {
        SearchScreen()
    }
}