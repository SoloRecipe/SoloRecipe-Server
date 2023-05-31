package com.sr.solorecipe.domain.recipe.presentation.data.dto

import com.sr.solorecipe.domain.review.domain.presentation.dto.ReviewDto


data class RecipeDetailDto (
    val idx: Long,
    val name: String,
    val thumbnail: String,
    val recipeProcess: List<RecipeProcessDto>,
    val reviews: List<ReviewDto>
)
