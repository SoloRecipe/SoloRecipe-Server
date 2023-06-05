package com.sr.solorecipe.domain.recipe.presentation.data.dto

data class CreateRecipeDto(
     val name: String,
     val thumbnail: String,
     val recipeProcess: List<RecipeProcessDto>
) {
    data class RecipeProcessDto(
            val description: String,
            val image: String
    )
}