package com.sr.solorecipe.domain.recipe.presentation.data.dto

import com.fasterxml.jackson.databind.BeanDescription

data class ModifyRecipeProcessDto(
    val description: String,
    val image: String
)
