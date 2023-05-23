package com.sr.solorecipe.domain.recipe.domain.repository

import com.sr.solorecipe.domain.recipe.domain.entity.Recipe
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeRepository: JpaRepository<Recipe, Long> {
}