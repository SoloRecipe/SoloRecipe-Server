package com.sr.solorecipe.domain.recipe.util.impl

import com.sr.solorecipe.domain.recipe.domain.entity.Recipe
import com.sr.solorecipe.domain.recipe.presentation.data.dto.*
import com.sr.solorecipe.domain.recipe.presentation.data.request.CreateRecipeRequest
import com.sr.solorecipe.domain.recipe.presentation.data.request.ModifyRecipeRequest
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeDetailResponse
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeListResponse
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeProcessResponse
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeResponse
import com.sr.solorecipe.domain.recipe.util.RecipeConverter
import com.sr.solorecipe.domain.review.domain.presentation.dto.ReviewDto
import com.sr.solorecipe.domain.review.domain.presentation.response.ReviewResponse
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

    override fun toDto(request: CreateRecipeRequest, dto: List<CreateRecipeDto.RecipeProcessDto>): CreateRecipeDto =
            CreateRecipeDto(
                    name = request.name,
                    thumbnail = request.thumbnail,
                    recipeProcess = dto
            )

    override fun toDto(request: CreateRecipeRequest.RecipeProcessRequest): CreateRecipeDto.RecipeProcessDto =
            CreateRecipeDto.RecipeProcessDto(
                    description = request.description,
                    image = request.image
            )

    override fun toDto(recipe: Recipe, recipeProcessDto: List<RecipeProcessDto>, reviewDto: List<ReviewDto>): RecipeDetailDto =
        RecipeDetailDto(
            idx = recipe.idx,
            name = recipe.name,
            thumbnail = recipe.thumbnail,
            recipeProcess = recipeProcessDto,
            reviews = reviewDto
        )

    override fun toDto(
        modifyRecipeRequest: ModifyRecipeRequest,
        modifyRecipeProcessDto: List<ModifyRecipeProcessDto>
    ): ModifyRecipeDto =
        ModifyRecipeDto(
            name = modifyRecipeRequest.name,
            thumbnail = modifyRecipeRequest.thumbnail,
            recipeProcess = modifyRecipeProcessDto
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

    override fun toResponse(
        recipeDetailDto: RecipeDetailDto,
        recipeProcessResponse: List<RecipeProcessResponse>,
        reviewResponse: List<ReviewResponse>
    ): RecipeDetailResponse =
        RecipeDetailResponse(
            idx = recipeDetailDto.idx,
            name = recipeDetailDto.name,
            thumbnail = recipeDetailDto.thumbnail,
            recipeProcess = recipeProcessResponse,
            reviews = reviewResponse
        )
}