package com.sr.solorecipe.domain.recipe.presentation.data.dto

import java.awt.print.Pageable

data class RecipeListDto(
    val pageable: Pageable,
    val recipeList: List<RecipeDto>
)
