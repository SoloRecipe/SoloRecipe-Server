package com.sr.solorecipe.domain.recipe.domain.repository

import com.sr.solorecipe.domain.recipe.domain.entity.Recipe
import com.sr.solorecipe.domain.user.domain.entity.User
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeRepository: JpaRepository<Recipe, Long> {
    fun findAllByOrderByRecipeViewsViewsDesc(pageable: Pageable): List<Recipe>
    fun findAllByUser(user: User): List<Recipe>
}