package com.sr.solorecipe.domain.recipe.domain.repository

import com.sr.solorecipe.domain.recipe.domain.entity.RecipeProcess
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeProcessRepository: JpaRepository<RecipeProcess, Long> {
    fun findAllByRecipeIdx(idx: Long): List<RecipeProcess>
}