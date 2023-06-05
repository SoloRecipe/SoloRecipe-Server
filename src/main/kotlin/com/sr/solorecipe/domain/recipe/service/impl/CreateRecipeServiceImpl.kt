package com.sr.solorecipe.domain.recipe.service.impl

import com.sr.solorecipe.domain.recipe.domain.entity.Recipe
import com.sr.solorecipe.domain.recipe.domain.entity.RecipeProcess
import com.sr.solorecipe.domain.recipe.domain.entity.RecipeViews
import com.sr.solorecipe.domain.recipe.domain.repository.RecipeProcessRepository
import com.sr.solorecipe.domain.recipe.domain.repository.RecipeRepository
import com.sr.solorecipe.domain.recipe.presentation.data.dto.CreateRecipeDto
import com.sr.solorecipe.domain.recipe.service.CreateRecipeService
import com.sr.solorecipe.domain.user.util.UserUtil
import org.springframework.stereotype.Service

@Service
class CreateRecipeServiceImpl(
        private val recipeRepository: RecipeRepository,
        private val recipeProcessRepository: RecipeProcessRepository,
        private val userUtil: UserUtil
) : CreateRecipeService {
    override fun createRecipe(dto: CreateRecipeDto) {
        val user = userUtil.currentUser()
        val recipe = Recipe(
                name = dto.name,
                thumbnail = dto.thumbnail,
                user = user,
                recipeViews = RecipeViews(0)
        )
        val saveRecipe = recipeRepository.save(recipe)
        recipeProcessRepository.saveAll(dto.recipeProcess
                .map { RecipeProcess(it.description, it.image, saveRecipe) }
        )
    }
}