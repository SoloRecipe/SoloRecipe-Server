package com.sr.solorecipe.domain.recipe.presentation

import com.sr.solorecipe.domain.recipe.presentation.data.request.ModifyRecipeRequest
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeDetailResponse
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeListResponse
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeResponse
import com.sr.solorecipe.domain.recipe.service.GetRecipeDetailService
import com.sr.solorecipe.domain.recipe.service.GetRecipeListService
import com.sr.solorecipe.domain.recipe.service.GetRecipeListSortedByRecipeViewsService
import com.sr.solorecipe.domain.recipe.service.ModifyRecipeService
import com.sr.solorecipe.domain.recipe.util.RecipeConverter
import com.sr.solorecipe.domain.recipe.util.RecipeProcessConverter
import com.sr.solorecipe.domain.review.domain.util.ReviewConverter
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/recipe")
class RecipeController(
    private val recipeConverter: RecipeConverter,
    private val recipeProcessConverter: RecipeProcessConverter,
    private val reviewConverter: ReviewConverter,
    private val getRecipeListSortedByRecipeViewsService: GetRecipeListSortedByRecipeViewsService,
    private val getRecipeDetailService: GetRecipeDetailService,
    private val modifyRecipeService: ModifyRecipeService,
    private val getRecipeListService: GetRecipeListService
) {

    @GetMapping("/suggest")
    fun getRecipeListSortedByRecipeViews(@RequestParam pageable: Pageable): ResponseEntity<RecipeListResponse> {
        val recipeListDto = getRecipeListSortedByRecipeViewsService.getRecipeList(pageable)
        val recipeResponse: List<RecipeResponse> = recipeListDto.recipeList
            .map(recipeConverter::toResponse)

        return ResponseEntity.ok(recipeConverter.toResponse(recipeListDto.pageable, recipeResponse))
    }

    @GetMapping("/all")
    fun getRecipeList(@RequestParam pageable: Pageable): ResponseEntity<RecipeListResponse> {
        val recipeListDto = getRecipeListService.getRecipeList(pageable)
        val recipeResponse: List<RecipeResponse> = recipeListDto.recipeList
                .map(recipeConverter::toResponse)

        return ResponseEntity.ok(recipeConverter.toResponse(recipeListDto.pageable, recipeResponse))

    }
    @GetMapping("/search")
    fun searchRecipe(@RequestParam name: String): ResponseEntity<Void> {
        return ResponseEntity.ok().build()
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

    @PatchMapping("/{idx}")
    fun modifyRecipe(@PathVariable("idx")idx: Long, @RequestBody modifyRecipeRequest: ModifyRecipeRequest): ResponseEntity<Void> {
        val modifyRecipeProcessDto = modifyRecipeRequest.recipeProcess
            .map(recipeProcessConverter::toDto)
        modifyRecipeService.modify(idx, recipeConverter.toDto(modifyRecipeRequest, modifyRecipeProcessDto))

        return ResponseEntity.noContent().build()
    }



}