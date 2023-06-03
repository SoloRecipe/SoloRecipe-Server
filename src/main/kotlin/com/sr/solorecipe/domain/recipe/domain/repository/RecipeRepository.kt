package com.sr.solorecipe.domain.recipe.domain.repository

import com.sr.solorecipe.domain.recipe.domain.entity.Recipe
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeRepository: JpaRepository<Recipe, Long> {
    fun findAllByOrderByRecipeViewsViewsDesc(pageable: Pageable): List<Recipe>
    override fun findAll(pageable: Pageable): Page<Recipe>

}