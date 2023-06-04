package com.sr.solorecipe.domain.recipe.util

import com.sr.solorecipe.domain.recipe.domain.entity.Recipe
import com.sr.solorecipe.domain.recipe.presentation.data.dto.*
import com.sr.solorecipe.domain.recipe.presentation.data.request.CreateRecipeRequest
import com.sr.solorecipe.domain.recipe.presentation.data.request.ModifyRecipeRequest
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeDetailResponse
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeListResponse
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeProcessResponse
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeResponse
import com.sr.solorecipe.domain.review.domain.presentation.dto.ReviewDto
import com.sr.solorecipe.domain.review.domain.presentation.response.ReviewResponse
import org.springframework.data.domain.Pageable

interface RecipeConverter {
    fun toDto(recipe: Recipe): RecipeDto
    fun toDto(pageable: Pageable, recipeDto: List<RecipeDto>): RecipeListDto
    fun toDto(request: CreateRecipeRequest, dto: List<CreateRecipeDto.RecipeProcessDto>): CreateRecipeDto
    fun toDto(request: CreateRecipeRequest.RecipeProcessRequest): CreateRecipeDto.RecipeProcessDto
    fun toDto(recipe: Recipe, recipeProcessDto: List<RecipeProcessDto>, reviewDto: List<ReviewDto>): RecipeDetailDto
    fun toDto(modifyRecipeRequest: ModifyRecipeRequest, modifyRecipeProcessDto: List<ModifyRecipeProcessDto>): ModifyRecipeDto
    fun toResponse(recipeDto: RecipeDto): RecipeResponse
    fun toResponse(pageable: Pageable, recipeListResponse: List<RecipeResponse>): RecipeListResponse
    fun toResponse(recipeDetailDto: RecipeDetailDto, recipeProcessResponse: List<RecipeProcessResponse>, reviewResponse: List<ReviewResponse>): RecipeDetailResponse
}