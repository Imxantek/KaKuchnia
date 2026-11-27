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
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.IconButton
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import com.example.kakuchnia.components.RecipeCard
import com.example.kakuchnia.components.mockupRecipes

@Composable
fun SearchScreen(modifier: Modifier = Modifier, onRecipeClick: (Int)-> Unit={}) {
    var query by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Szukaj...",
            fontSize = 40.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            TextField(
                value = query,
                onValueChange = { query = it },
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = { }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_filters),
                    contentDescription = "Filtry"
                )
            }
            IconButton(
                onClick = { }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_sort),
                    contentDescription = "Sortuj"
                )
            }
        }

        Row (modifier = Modifier.padding(horizontal = 16.dp)) {
            Button(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = "Wszystkie"
                )
            }

            Button(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = "Ulubione"
                )
            }

            Button(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = "Moje"
                )
            }
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(mockupRecipes) { recipe ->
                RecipeCard(recipe, {onRecipeClick(recipe.id)})
            }
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