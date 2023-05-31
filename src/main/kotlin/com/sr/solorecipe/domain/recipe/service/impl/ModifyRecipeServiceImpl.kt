package com.sr.solorecipe.domain.recipe.service.impl

import com.sr.solorecipe.domain.recipe.domain.repository.RecipeProcessRepository
import com.sr.solorecipe.domain.recipe.domain.repository.RecipeRepository
import com.sr.solorecipe.domain.recipe.presentation.data.dto.ModifyRecipeDto
import com.sr.solorecipe.domain.recipe.service.ModifyRecipeService
import org.springframework.stereotype.Service

@Service
class ModifyRecipeServiceImpl(
    private val recipeRepository: RecipeRepository,
    private val recipeProcessRepository: RecipeProcessRepository
): ModifyRecipeService {
    override fun modify(toDto: ModifyRecipeDto) {

    }
}