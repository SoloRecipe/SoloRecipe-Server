package com.sr.solorecipe.domain.recipe.service.impl

import com.sr.solorecipe.domain.recipe.domain.repository.RecipeRepository
import com.sr.solorecipe.domain.recipe.presentation.data.dto.RecipeListDto
import com.sr.solorecipe.domain.recipe.service.GetRecipeListSortedByRecipeViewsService
import com.sr.solorecipe.domain.recipe.util.RecipeConverter
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class GetRecipeListSortedByRecipeViewsServiceImpl(
    private val recipeConverter: RecipeConverter,
    private val recipeRepository: RecipeRepository,
): GetRecipeListSortedByRecipeViewsService {
    override fun getRecipeList(pageable: Pageable): RecipeListDto {
        val sortedByRecipeViewsListDto = recipeRepository.findAllByOrderByRecipeViewsViewsDesc(pageable)
            .map { recipe -> recipeConverter.toDto(recipe) }

        return recipeConverter.toDto(pageable, sortedByRecipeViewsListDto)
    }
}