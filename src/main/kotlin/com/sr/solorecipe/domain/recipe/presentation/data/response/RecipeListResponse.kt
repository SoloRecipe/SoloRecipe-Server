package com.sr.solorecipe.domain.recipe.presentation.data.response

data class RecipeListResponse(
    val page: Int,
    val size: Int,
    val recipeList: List<RecipeResponse>
)
