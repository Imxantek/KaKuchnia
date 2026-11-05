package com.example.kakuchnia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kakuchnia.ui.theme.KaKuchniaTheme
import com.example.kakuchnia.screens.*
import androidx.navigation.NavGraph.Companion.findStartDestination
import java.time.LocalDate


sealed class Screen(val route: String, val title: String, val iconResId: Int) {
    object Settings : Screen("settings", "Settings", R.drawable.ic_cogwheel)
    object Calendar : Screen("calendar", "Calendar", R.drawable.ic_calendar)
    object Add : Screen("add", "Add", R.drawable.ic_plus)
    object Search : Screen("search", "Search", R.drawable.ic_search)
    object Home : Screen("home", "Home", R.drawable.ic_home)

}

data class Recipe(
    val id: Int,
    val title: String,
    val description: String,
    val preparation_time: Int,
    val is_favourite: Boolean,
    val user_added: Boolean,
)
data class Image(
    val path: Int,
    val recipe: Int
)
data class planned_recipe(
    val date: LocalDate,
    val recipe: Int
)
data class recipe_ingredient(
    val recipe: Int,
    val ingredient: String,
    val amount: Double,
    val unit: String
)
data class Ingedient(
    val name: String,
)



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KaKuchniaTheme {
                MainScreen()
            }
        }
    }
}



@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf(
        Screen.Settings,
        Screen.Calendar,
        Screen.Add,
        Screen.Search,
        Screen.Home
    )
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                items.forEach { screen ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.iconResId),
                                contentDescription = "Home"
                            )
                        },
                        label = { Text(screen.title) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            if (currentRoute != screen.route) {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    ){ innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.Search.route) { SearchScreen() }
            composable ( Screen.Add.route ) { AddScreen() }
            composable(Screen.Calendar.route) { CalendarScreen() }
            composable(Screen.Settings.route) { SettingsScreen() }
        }
    }
}


