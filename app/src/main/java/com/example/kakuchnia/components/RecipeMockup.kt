package com.example.kakuchnia.components

import com.example.kakuchnia.R

val mockupRecipes: List<Recipe> = List(5) {listOf(
        Recipe(
            id = 1,
            title = "Karp smażony",
            description = "this is a mockup. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed placerat urna ut maximus ornare. In sodales et tellus sed efficitur. Morbi sed quam a ante porta accumsan. Donec maximus nulla eu sodales congue. Mauris pellentesque vel ipsum et sodales. Donec porttitor dolor a pharetra sagittis. Suspendisse sagittis hendrerit nibh, a pharetra justo scelerisque in. Aenean mattis, libero ac vehicula hendrerit, felis ante eleifend dolor, tristique viverra ante tellus ut sem. Integer cursus semper eros, et interdum tellus convallis a. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed placerat urna ut maximus ornare. In sodales et tellus sed efficitur. Morbi sed quam a ante porta accumsan. Donec maximus nulla eu sodales congue. Mauris pellentesque vel ipsum et sodales. Donec porttitor dolor a pharetra sagittis. Suspendisse sagittis hendrerit nibh, a pharetra justo scelerisque in. Aenean mattis, libero ac vehicula hendrerit, felis ante eleifend dolor, tristique viverra ante tellus ut sem. Integer cursus semper eros, et interdum tellus convallis a. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed placerat urna ut maximus ornare. In sodales et tellus sed efficitur. Morbi sed quam a ante porta accumsan. Donec maximus nulla eu sodales congue. Mauris pellentesque vel ipsum et sodales. Donec porttitor dolor a pharetra sagittis. Suspendisse sagittis hendrerit nibh, a pharetra justo scelerisque in. Aenean mattis, libero ac vehicula hendrerit, felis ante eleifend dolor, tristique viverra ante tellus ut sem. Integer cursus semper eros, et interdum tellus convallis a.",
            preparation_time = 90,
            is_favourite = true,
            user_added = false,
            ingredients = listOf(
                RecipeIngredient(ingredient = "tuszka karpia", amount = 1.0, unit = "sztuka"),
                RecipeIngredient(ingredient = "sok z cytryny", amount = 1.0, unit = "sztuka"),
                RecipeIngredient(ingredient = "sól", amount = 1.0, unit = "łyżka"),
                RecipeIngredient(ingredient = "bułka tarta", amount = 2.0, unit = "łyżki"),
                RecipeIngredient(ingredient = "lorem", amount = 1.0, unit = "sztuka"),
                RecipeIngredient(ingredient = "ipsum", amount = 1.0, unit = "sztuka"),
                RecipeIngredient(ingredient = "dolor", amount = 1.0, unit = "sztuka"),
                RecipeIngredient(ingredient = "sit", amount = 1.0, unit = "sztuka"),
                RecipeIngredient(ingredient = "amet", amount = 1.0, unit = "sztuka"),

            ),
            images = listOf(
                Image(
                    path = R.drawable.karp_smazony,
                ), Image(
                    path = R.drawable.karp_smazony_1,
                ), Image(
                    path = R.drawable.karp_smazony_2,
                )
            )
        ),
        Recipe(
            id = 2,
            title = "Sernik z Air Fryera",
            description = "this is a mockup",
            preparation_time = 65,
            is_favourite = true,
            user_added = true,
            ingredients=listOf(),
            images = listOf(
                Image(
                    path = R.drawable.sernik_z_airfryera,
                )
            )
        )
    )}.flatten()



