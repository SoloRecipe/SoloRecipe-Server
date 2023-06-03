package com.sr.solorecipe.domain.recipe.event.handler

import com.sr.solorecipe.domain.recipe.domain.repository.RecipeViewsRepository
import com.sr.solorecipe.domain.recipe.event.SawRecipeDetailEvent
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class RecipeViewsHandler(
    private val recipeViewsRepository: RecipeViewsRepository
) {
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun addRecipeViews(event: SawRecipeDetailEvent) {
        val recipeViews = event.recipeViews
        recipeViews.add()
        recipeViewsRepository.save(recipeViews)
    }
}