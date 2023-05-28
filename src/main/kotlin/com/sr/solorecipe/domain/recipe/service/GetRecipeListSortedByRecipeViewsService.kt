package com.sr.solorecipe.domain.recipe.service

import com.sr.solorecipe.domain.recipe.presentation.data.dto.RecipeListDto
import org.springframework.data.domain.Pageable

interface GetRecipeListSortedByRecipeViewsService {
    fun getRecipeList(pageable: Pageable): RecipeListDto
}
