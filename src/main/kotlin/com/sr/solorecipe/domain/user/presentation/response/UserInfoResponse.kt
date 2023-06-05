package com.sr.solorecipe.domain.user.presentation.response

import com.sr.solorecipe.domain.recipe.presentation.data.response.RecipeResponse

data class UserInfoResponse(
    val name: String,
    val likeRecipe: List<UserInfoRecipeResponse>,
    val myRecipe: List<UserInfoRecipeResponse>
)
