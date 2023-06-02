package com.sr.solorecipe.domain.recipe.presentation.data.request

data class ModifyRecipeRequest(
    val name: String,
    val thumbnail: String,
    val recipeProcess: List<ModifyRecipeProcessRequest>
)
