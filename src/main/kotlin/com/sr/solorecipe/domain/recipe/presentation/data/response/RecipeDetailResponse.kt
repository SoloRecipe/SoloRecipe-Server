package com.sr.solorecipe.domain.recipe.presentation.data.response

import com.sr.solorecipe.domain.review.presentation.response.ReviewResponse

data class RecipeDetailResponse(
    val idx: Long,
    val name: String,
    val thumbnail: String,
    val recipeProcess: List<RecipeProcessResponse>,
    val reviews: List<ReviewResponse>
)
