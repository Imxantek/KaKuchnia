package com.example.kakuchnia.components

import com.example.kakuchnia.R

sealed class Screen(val route: String, val title: String, val iconResId: Int?=null) {
    object Settings : Screen("settings", "Settings", R.drawable.ic_cogwheel)
    object Calendar : Screen("calendar", "Calendar", R.drawable.ic_calendar)
    object Add : Screen("add", "Add", R.drawable.ic_plus)
    object Search : Screen("search", "Search", R.drawable.ic_search)
    object Home : Screen("home", "Home", R.drawable.ic_home)

    object IndividualRecipe : Screen("individual_recipe", "Individual Recipe")

}