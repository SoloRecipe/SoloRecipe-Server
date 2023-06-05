package com.sr.solorecipe.domain.recipe.service.impl

import com.sr.solorecipe.domain.recipe.domain.repository.RecipeRepository
import com.sr.solorecipe.domain.recipe.presentation.data.dto.RecipeListDto
import com.sr.solorecipe.domain.recipe.service.GetRecipeListService
import com.sr.solorecipe.domain.recipe.service.GetRecipeListSortedByRecipeViewsService
import com.sr.solorecipe.domain.recipe.util.RecipeConverter
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class GetRecipeListServiceImpl(
    private val recipeConverter: RecipeConverter,
    private val recipeRepository: RecipeRepository,
): GetRecipeListService {
    override fun getRecipeList(pageable: Pageable): RecipeListDto =
        recipeRepository.findAll(pageable).toList()
                .map{ recipeConverter.toDto(it) }
                .let { recipeConverter.toDto(pageable, it) }

}