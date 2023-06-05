package com.sr.solorecipe.domain.recipe.service.impl

import com.sr.solorecipe.domain.recipe.domain.repository.RecipeRepository
import com.sr.solorecipe.domain.recipe.presentation.data.dto.RecipeDto
import com.sr.solorecipe.domain.recipe.service.SearchRecipeService
import com.sr.solorecipe.domain.recipe.util.RecipeConverter
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class SearchRecipeServiceImpl(
        private val recipeRepository: RecipeRepository,
        private val recipeConverter: RecipeConverter
) : SearchRecipeService {
    override fun searchRecipe(name: String): List<RecipeDto> =
            recipeRepository.findRecipeByNameContaining(name)
                    .map { recipeConverter.toDto(it) }
}