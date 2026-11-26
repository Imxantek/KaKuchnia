package com.example.kakuchnia.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kakuchnia.R
import com.example.kakuchnia.ui.theme.KaKuchniaTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kakuchnia.components.Image
import com.example.kakuchnia.components.Recipe
import com.example.kakuchnia.components.RecipeCard

val mockupRecipes: List<Recipe> = listOf(
    Recipe(
        id=1,
        title="Karp smażony",
        description = "this is a mockup",
        preparation_time=90,
        is_favourite=true,
        user_added=false,
    ),
    Recipe(
        id=2,
        title="Sernik z Air Fryera",
        description = "this is a mockup",
        preparation_time=65,
        is_favourite=true,
        user_added=false,
    ),
    Recipe(
        id=1,
        title="Karp smażony",
        description = "this is a mockup",
        preparation_time=90,
        is_favourite=true,
        user_added=false,
    ),
    Recipe(
        id=2,
        title="Sernik z Air Fryera",
        description = "this is a mockup",
        preparation_time=65,
        is_favourite=true,
        user_added=false,
    ),
    Recipe(
        id=1,
        title="Karp smażony",
        description = "this is a mockup",
        preparation_time=90,
        is_favourite=true,
        user_added=false,
    ),
    Recipe(
        id=2,
        title="Sernik z Air Fryera",
        description = "this is a mockup",
        preparation_time=65,
        is_favourite=true,
        user_added=false,
    ),
    Recipe(
        id=1,
        title="Karp smażony",
        description = "this is a mockup",
        preparation_time=90,
        is_favourite=true,
        user_added=false,
    ),
    Recipe(
        id=2,
        title="Sernik z Air Fryera",
        description = "this is a mockup",
        preparation_time=65,
        is_favourite=true,
        user_added=false,
    ),
    Recipe(
        id=1,
        title="Karp smażony",
        description = "this is a mockup",
        preparation_time=90,
        is_favourite=true,
        user_added=false,
    ),
    Recipe(
        id = 2,
        title = "Sernik z Air Fryera",
        description = "this is a mockup",
        preparation_time = 65,
        is_favourite = true,
        user_added = false,
    ),
    Recipe(
        id=1,
        title="Karp smażony",
        description = "this is a mockup",
        preparation_time=90,
        is_favourite=true,
        user_added=false,
    ),
    Recipe(
        id=2,
        title="Sernik z Air Fryera",
        description = "this is a mockup",
        preparation_time=65,
        is_favourite=true,
        user_added=false,
    )
)

val mockupImages: List<Image> = listOf(
    Image(
        path=R.drawable.karp_smazony,
        recipe=1
    ),
    Image(
        path=R.drawable.sernik_z_airfryera,
        recipe=2
    )
)

@Composable
fun Greeting(){
    Column (
        modifier = Modifier.border(width=10.dp, color= Color.Transparent),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            text = "Witaj w KaKuchnia!",
            fontSize = 30.sp,
        )
        Text(
            text = "Co dzisiaj ugotujemy??",
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
}


@Composable
fun HomeScreen(modifier: Modifier = Modifier, onRecipeClick: ()->Unit={}) {
    Scaffold(
        modifier=modifier,
        topBar = {
            Greeting()
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ){
            items(mockupRecipes) { recipe ->
                RecipeCard(recipe, onRecipeClick)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    KaKuchniaTheme {
        HomeScreen()
    }
}