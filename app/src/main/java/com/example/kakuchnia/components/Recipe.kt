package com.example.kakuchnia.components

data class Recipe(
    val id: Int,
    val title: String,
    val description: String,
    val preparation_time: Int,
    val is_favourite: Boolean,
    val user_added: Boolean,
)