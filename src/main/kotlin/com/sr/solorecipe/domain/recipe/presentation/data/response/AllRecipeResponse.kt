package com.sr.solorecipe.domain.recipe.presentation.data.response

data class AllRecipeResponse(
        val page: Int,
        val size: Int,
        val recipeList: List<RecipeResponse>
) {
    data class RecipeResponse(
            val idx: Long,
            val name: String,
            val thumbnail: String
    )
}
