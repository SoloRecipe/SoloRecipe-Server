package com.sr.solorecipe.domain.recipe.event

import com.sr.solorecipe.domain.recipe.domain.entity.RecipeViews

data class SawRecipeDetailEvent(val recipeViews: RecipeViews) {
}
