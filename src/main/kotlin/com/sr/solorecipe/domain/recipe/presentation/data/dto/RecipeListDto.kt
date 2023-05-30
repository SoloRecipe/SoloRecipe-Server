package com.sr.solorecipe.domain.recipe.presentation.data.dto

import org.springframework.data.domain.Pageable

data class RecipeListDto(
    val pageable: Pageable,
    val recipeList: List<RecipeDto>
)
