package com.sr.solorecipe.domain.recipe.service.impl

import com.sr.solorecipe.domain.recipe.domain.repository.RecipeProcessRepository
import com.sr.solorecipe.domain.recipe.domain.repository.RecipeRepository
import com.sr.solorecipe.domain.recipe.exception.RecipeNotFoundException
import com.sr.solorecipe.domain.recipe.presentation.data.dto.ModifyRecipeDto
import com.sr.solorecipe.domain.recipe.service.ModifyRecipeService
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional(rollbackOn = [Exception::class])
class ModifyRecipeServiceImpl(
    private val recipeRepository: RecipeRepository,
    private val recipeProcessRepository: RecipeProcessRepository,
): ModifyRecipeService {
    override fun modify(idx: Long, modifyRecipeDto: ModifyRecipeDto) {
        val foundRecipe = recipeRepository.findById(idx)
            .orElseGet { throw RecipeNotFoundException() }
        val foundRecipeProcess = recipeProcessRepository.findAllByRecipeIdx(idx)

        foundRecipe.modify(modifyRecipeDto.name, modifyRecipeDto.thumbnail)
        foundRecipeProcess
            .map { recipeProcess ->
                recipeProcess.modify(modifyRecipeDto.recipeProcess[(recipeProcess.idx - 1).toInt()]) }
    }
}