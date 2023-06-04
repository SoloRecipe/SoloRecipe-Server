package com.sr.solorecipe.domain.recipe.service

import com.sr.solorecipe.domain.recipe.presentation.data.dto.RecipeDto

interface SearchRecipeService {
    fun searchRecipe(name: String): List<RecipeDto>
}