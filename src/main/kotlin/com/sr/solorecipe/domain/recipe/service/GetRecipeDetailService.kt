package com.sr.solorecipe.domain.recipe.service

import com.sr.solorecipe.domain.recipe.presentation.data.dto.RecipeDetailDto

interface GetRecipeDetailService {
    fun getRecipeDetail(idx: Long): RecipeDetailDto
}
