package com.sr.solorecipe.domain.recipe.service

import com.sr.solorecipe.domain.recipe.presentation.data.dto.ModifyRecipeDto

interface ModifyRecipeService {
    fun modify(idx: Long,modifyRecipeDto: ModifyRecipeDto)
}
