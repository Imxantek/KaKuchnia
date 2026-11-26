package com.example.kakuchnia.components

data class RecipeIngredient(
    val recipe: Int,
    val ingredient: String,
    val amount: Double,
    val unit: String
)