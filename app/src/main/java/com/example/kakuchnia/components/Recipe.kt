package com.example.kakuchnia.components

data class Recipe(
    var id: Int,
    var title: String,
    var description: String,
    var preparation_time: Int,
    var is_favourite: Boolean,
    val user_added: Boolean,
    var ingredients: List<RecipeIngredient>,
    var images: List<Image>,
)