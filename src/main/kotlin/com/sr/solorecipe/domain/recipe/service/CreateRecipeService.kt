package com.sr.solorecipe.domain.recipe.service

import com.sr.solorecipe.domain.recipe.presentation.data.dto.CreateRecipeDto

interface CreateRecipeService {
    fun createRecipe(dto: CreateRecipeDto)
}