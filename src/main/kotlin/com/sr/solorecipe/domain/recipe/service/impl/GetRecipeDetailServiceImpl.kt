package com.sr.solorecipe.domain.recipe.service.impl;

import com.sr.solorecipe.domain.recipe.domain.repository.RecipeProcessRepository
import com.sr.solorecipe.domain.recipe.domain.repository.RecipeRepository
import com.sr.solorecipe.domain.recipe.exception.RecipeNotFoundException
import com.sr.solorecipe.domain.recipe.presentation.data.dto.RecipeDetailDto
import com.sr.solorecipe.domain.recipe.service.GetRecipeDetailService
import com.sr.solorecipe.domain.recipe.util.RecipeConverter
import com.sr.solorecipe.domain.recipe.util.RecipeProcessConverter
import com.sr.solorecipe.domain.review.domain.repository.ReviewRepository
import com.sr.solorecipe.domain.review.domain.util.ReviewConverter
import org.springframework.stereotype.Service;

@Service
class GetRecipeDetailServiceImpl(
    private val recipeConverter: RecipeConverter,
    private val recipeRepository: RecipeRepository,
    private val recipeProcessRepository: RecipeProcessRepository,
    private val recipeProcessConverter: RecipeProcessConverter,
    private val reviewRepository: ReviewRepository,
    private val reviewConverter: ReviewConverter,
): GetRecipeDetailService {
    override fun getRecipeDetail(idx: Long): RecipeDetailDto {
        val recipe = recipeRepository.findById(idx)
            .orElseThrow { throw RecipeNotFoundException() }
        val recipeProcessDto = recipeProcessRepository.findAllByRecipeIdx(idx)
            .map { recipeProcessConverter.toDto(it) }
        val reviewDto = reviewRepository.findAllByRecipeIdx(idx)
            .map { reviewConverter.toDto(it) }

        return recipeConverter.toDto(recipe, recipeProcessDto, reviewDto)
    }

}
