package com.sr.solorecipe.domain.recipe.presentation.data.dto

data class ModifyRecipeDto(
    val name: String,
    val thumbnail: String,
    val recipeProcess: List<ModifyRecipeProcessDto>
)
