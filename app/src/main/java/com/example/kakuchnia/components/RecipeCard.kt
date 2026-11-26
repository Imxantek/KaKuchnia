package com.example.kakuchnia.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kakuchnia.screens.mockupImages

@Composable
fun RecipeCard(recipe: Recipe, onRecipeClick: () -> Unit) {
    val id = recipe.id
    val title = recipe.title
    val preparation_time = recipe.preparation_time
    val img_path = mockupImages.find { it.recipe == id }
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal=20.dp)
            .height(190.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = img_path!!.path),
                contentDescription = "Recipe image",
                modifier = Modifier
                    .fillMaxHeight()
                    .width(190.dp)
                    .clip(RoundedCornerShape(19.dp))
            )
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(12.dp)
                .clickable { onRecipeClick() }
            ){
                Text(
                    text = title,
                    fontSize = 22.sp,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Czas przygotowania:\n$preparation_time min",
                    fontSize = 16.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
