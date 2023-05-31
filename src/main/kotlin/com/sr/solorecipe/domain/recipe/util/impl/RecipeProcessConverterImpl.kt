package com.sr.solorecipe.domain.recipe.util.impl

import com.sr.solorecipe.domain.recipe.domain.entity.RecipeProcess
import com.sr.solorecipe.domain.recipe.presentation.data.dto.ModifyRecipeProcessDto
import com.sr.solorecipe.domain.recipe.presentation.data.dto.RecipeProcessDto
import com.sr.solorecipe.domain.recipe.presentation.data.request.ModifyRecipeProcessRequest
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeProcessResponse
import com.sr.solorecipe.domain.recipe.util.RecipeProcessConverter
import org.springframework.stereotype.Component

@Component
class RecipeProcessConverterImpl(

): RecipeProcessConverter {
    override fun toDto(recipeProcess: RecipeProcess): RecipeProcessDto =
        RecipeProcessDto(
            idx = recipeProcess.idx,
            description = recipeProcess.description,
            image = recipeProcess.image
        )

    override fun toDto(modifyRecipeProcessRequest: ModifyRecipeProcessRequest): ModifyRecipeProcessDto =
        ModifyRecipeProcessDto(
            description = modifyRecipeProcessRequest.description,
            image = modifyRecipeProcessRequest.image
        )

    override fun toResponse(recipeProcessDto: RecipeProcessDto): RecipeProcessResponse =
        RecipeProcessResponse(
            idx = recipeProcessDto.idx,
            description = recipeProcessDto.description,
            image = recipeProcessDto.image
        )
}