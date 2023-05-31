package com.sr.solorecipe.domain.recipe.presentation

import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeDetailResponse
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeListResponse
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeResponse
import com.sr.solorecipe.domain.recipe.service.GetRecipeDetailService
import com.sr.solorecipe.domain.recipe.service.GetRecipeListSortedByRecipeViewsService
import com.sr.solorecipe.domain.recipe.util.RecipeConverter
import com.sr.solorecipe.domain.recipe.util.RecipeProcessConverter
import com.sr.solorecipe.domain.review.domain.util.ReviewConverter
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/recipe")
class RecipeController(
    private val recipeConverter: RecipeConverter,
    private val recipeProcessConverter: RecipeProcessConverter,
    private val reviewConverter: ReviewConverter,
    private val getRecipeListSortedByRecipeViewsService: GetRecipeListSortedByRecipeViewsService,
    private val getRecipeDetailService: GetRecipeDetailService
) {

    @GetMapping("/suggest")
    fun getRecipeListSortedByRecipeViews(pageable: Pageable): ResponseEntity<RecipeListResponse> {
        val recipeListDto = getRecipeListSortedByRecipeViewsService.getRecipeList(pageable)
        val recipeResponse: List<RecipeResponse> = recipeListDto.recipeList
            .map(recipeConverter::toResponse)

        return ResponseEntity.ok(recipeConverter.toResponse(recipeListDto.pageable, recipeResponse))
    }

    @GetMapping("/detail/{idx}")
    fun getRecipeDetail(@PathVariable("idx")idx: Long): ResponseEntity<RecipeDetailResponse> {
        val result = getRecipeDetailService.getRecipeDetail(idx)
        val recipeProcessResponse = result.recipeProcess
            .map(recipeProcessConverter::toResponse)
        val reviewResponse = result.reviews
            .map(reviewConverter::toResponse)

        return ResponseEntity.ok(recipeConverter.toResponse(result, recipeProcessResponse, reviewResponse))
    }
}