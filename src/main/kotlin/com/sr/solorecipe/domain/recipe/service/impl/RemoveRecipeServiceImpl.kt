package com.sr.solorecipe.domain.recipe.service.impl

import com.sr.solorecipe.domain.recipe.domain.repository.RecipeRepository
import com.sr.solorecipe.domain.recipe.exception.RecipeNotFoundException
import com.sr.solorecipe.domain.recipe.service.RemoveRecipeService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class RemoveRecipeServiceImpl(
        private val recipeRepository: RecipeRepository
) : RemoveRecipeService {
    override fun removeRecipe(idx: Long) {
        val recipe = recipeRepository.findById(idx).orElseThrow{ throw RecipeNotFoundException() }
        recipeRepository.delete(recipe)
    }
}