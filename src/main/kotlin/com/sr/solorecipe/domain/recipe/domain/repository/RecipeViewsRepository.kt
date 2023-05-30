package com.sr.solorecipe.domain.recipe.domain.repository

import com.sr.solorecipe.domain.recipe.domain.entity.RecipeViews
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeViewsRepository: JpaRepository<RecipeViews, Long> {
}