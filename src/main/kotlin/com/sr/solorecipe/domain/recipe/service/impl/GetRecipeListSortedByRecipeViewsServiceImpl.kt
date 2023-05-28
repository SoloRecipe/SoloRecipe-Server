package com.sr.solorecipe.domain.recipe.service.impl

import com.sr.solorecipe.domain.recipe.domain.repository.RecipeRepository
import com.sr.solorecipe.domain.recipe.presentation.data.dto.RecipeListDto
import com.sr.solorecipe.domain.recipe.service.GetRecipeListSortedByRecipeViewsService
import com.sr.solorecipe.domain.recipe.util.RecipeConverter
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class GetRecipeListSortedByRecipeViewsServiceImpl(
    private val recipeConverter: RecipeConverter,
    private val recipeRepository: RecipeRepository,
): GetRecipeListSortedByRecipeViewsService {
    override fun getRecipeList(pageable: Pageable): RecipeListDto {
        val sortedByRecipeViewsListDto = recipeRepository.findAll(pageable).stream()
            .map { recipe -> recipeConverter.toDto(recipe) }
            .sorted(compareByDescending { it.views })
            .toList()

        return recipeConverter.toDto(pageable, sortedByRecipeViewsListDto)
    }
}