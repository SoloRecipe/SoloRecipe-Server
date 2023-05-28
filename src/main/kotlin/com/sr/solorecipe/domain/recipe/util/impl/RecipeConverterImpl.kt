package com.sr.solorecipe.domain.recipe.util.impl

import com.sr.solorecipe.domain.recipe.domain.entity.Recipe
import com.sr.solorecipe.domain.recipe.presentation.data.dto.RecipeDto
import com.sr.solorecipe.domain.recipe.presentation.data.dto.RecipeListDto
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeListResponse
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeResponse
import com.sr.solorecipe.domain.recipe.util.RecipeConverter
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class RecipeConverterImpl(

): RecipeConverter {
    override fun toDto(recipe: Recipe): RecipeDto =
        RecipeDto(
            idx = recipe.idx,
            name = recipe.name,
            thumbnail = recipe.thumbnail,
            views = recipe.recipeViews.views
        )

    override fun toDto(pageable: Pageable, recipeDto: List<RecipeDto>): RecipeListDto =
        RecipeListDto(
            pageable = pageable,
            recipeList = recipeDto
        )

    override fun toResponse(recipeDto: RecipeDto): RecipeResponse =
        RecipeResponse(
            idx = recipeDto.idx,
            name = recipeDto.name,
            thumbnail = recipeDto.thumbnail
        )
    override fun toResponse(pageable: Pageable, recipeListResponse: List<RecipeResponse>): RecipeListResponse =
        RecipeListResponse(
            page = pageable.pageNumber,
            size = recipeListResponse.size,
            recipeList = recipeListResponse
        )
}