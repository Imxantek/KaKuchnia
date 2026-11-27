package com.example.kakuchnia.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kakuchnia.R
import com.example.kakuchnia.components.Recipe
import com.example.kakuchnia.components.mockupRecipes
import com.example.kakuchnia.ui.theme.KaKuchniaTheme
import androidx.compose.runtime.*

@Composable
fun RecipeScreen(modifier: Modifier = Modifier, recipe: Recipe? = null) {
    var bookmarked by remember { mutableStateOf(recipe?.is_favourite ?: false) }
    val pagerState = rememberPagerState(pageCount = { recipe?.images?.size ?: 0 })
    LazyColumn (modifier = modifier) {
        if (recipe == null) {
            item { Text(text = "Nie znaleziono przepisu", modifier = Modifier.padding(16.dp)) }
        } else {
            item {

                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(4f / 3f),
                ) { i ->
                    val image = recipe.images[i]
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = image.path),
                        contentScale = ContentScale.Crop,
                        contentDescription = null
                    )
                }
            }
            item {

                Row(modifier = Modifier.padding(12.dp)) {
                    Text(text = recipe.title, fontSize = 30.sp, modifier = Modifier.weight(0.6f))
                    Row(modifier = Modifier.padding(horizontal = 5.dp).weight(0.4f)) {
                        Spacer(modifier = Modifier.weight(1f))
                        val icon = if (bookmarked) R.drawable.ic_black_bookmark else R.drawable.ic_bookmark
                        IconButton(onClick = {
                            bookmarked = !bookmarked
                            recipe.is_favourite=bookmarked
                        }) {
                            Icon(
                                modifier = Modifier
                                    .padding(vertical = 6.dp),
                                painter = painterResource(id = icon),
                                contentDescription = "save",
                            )
                        }
                        if (recipe.user_added) {
                            Button(onClick = {/*todo*/ }) { Text("Edytuj") }
                        }
                    }
                }
            }
            item {
                Card(modifier = Modifier.padding(12.dp).fillMaxWidth().height(200.dp)) {
                    Text(text = "Składniki", fontSize = 20.sp, modifier = Modifier.padding(12.dp, 6.dp))
                    var list=""
                    recipe.ingredients.forEach{
                        list += "${it.ingredient} - ${it.amount} ${it.unit}\n"
                    }
                    Text(text = list, modifier = Modifier.padding(horizontal=12.dp), overflow = TextOverflow.Ellipsis)

                }
            }
            item {
                Text(text = recipe.description, modifier = Modifier.padding(12.dp))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RecipeScreenPreview() {
    KaKuchniaTheme {
        RecipeScreen(recipe=mockupRecipes[1])
    }
}