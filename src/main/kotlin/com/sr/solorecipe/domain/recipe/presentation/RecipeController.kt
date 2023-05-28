package com.sr.solorecipe.domain.recipe.presentation

import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeListResponse
import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeResponse
import com.sr.solorecipe.domain.recipe.service.GetRecipeListSortedByRecipeViewsService
import com.sr.solorecipe.domain.recipe.util.RecipeConverter
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.streams.toList

@RestController
@RequestMapping("/recipe")
class RecipeController(
    private val recipeConverter: RecipeConverter,
    private val getRecipeListSortedByRecipeViewsService: GetRecipeListSortedByRecipeViewsService
) {

    @GetMapping("/suggest")
    fun getRecipeListSortedByRecipeViews(pageable: Pageable): ResponseEntity<RecipeListResponse> {
        val recipeListDto = getRecipeListSortedByRecipeViewsService.getRecipeList(pageable)
        val recipeResponse: List<RecipeResponse> = recipeListDto.recipeList.stream()
            .map(recipeConverter::toResponse)
            .toList()
        return ResponseEntity.ok(recipeConverter.toResponse(recipeListDto.pageable, recipeResponse))
    }
}