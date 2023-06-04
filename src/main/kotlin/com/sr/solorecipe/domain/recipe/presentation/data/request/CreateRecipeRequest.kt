package com.sr.solorecipe.domain.recipe.presentation.data.request

data class CreateRecipeRequest(
     val name: String,
     val thumbnail: String,
     val recipeProcess: List<RecipeProcessRequest>
) {
    data class RecipeProcessRequest(
            val description: String,
            val image: String
    )
}