package com.sr.solorecipe.domain.recipe.presentation.data.dto

data class AllRecipeDto(
        val page: Int,
        val size: Int,
        val recipeList: List<RecipeDto>
) {
    data class RecipeDto(
            val idx: Long,
            val name: String,
            val thumbnail: String
    )
}
