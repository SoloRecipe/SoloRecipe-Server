package com.sr.solorecipe.domain.recipe.util

import com.sr.solorecipe.domain.recipe.domain.entity.Recipe
import com.sr.solorecipe.domain.recipe.presentation.data.dto.RecipeDto
import com.sr.solorecipe.domain.recipe.presentation.data.dto.RecipeListDto
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeListResponse
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeResponse
import org.springframework.data.domain.Pageable

interface RecipeConverter {
    fun toDto(recipe: Recipe): RecipeDto
    fun toDto(pageable: Pageable, recipeDto: List<RecipeDto>): RecipeListDto
    fun toResponse(recipeDto: RecipeDto): RecipeResponse
    fun toResponse(pageable: Pageable, recipeListResponse: List<RecipeResponse>): RecipeListResponse
}