package com.sr.solorecipe.domain.recipe.util

import com.sr.solorecipe.domain.recipe.domain.entity.RecipeProcess
import com.sr.solorecipe.domain.recipe.presentation.data.dto.ModifyRecipeProcessDto
import com.sr.solorecipe.domain.recipe.presentation.data.dto.RecipeProcessDto
import com.sr.solorecipe.domain.recipe.presentation.data.request.ModifyRecipeProcessRequest
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeProcessResponse

interface RecipeProcessConverter {
    fun toDto(recipeProcess: RecipeProcess): RecipeProcessDto
    fun toDto(modifyRecipeProcessRequest: ModifyRecipeProcessRequest): ModifyRecipeProcessDto
    fun toResponse(recipeProcessDto: RecipeProcessDto): RecipeProcessResponse

}