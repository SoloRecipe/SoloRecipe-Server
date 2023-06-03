package com.sr.solorecipe.domain.user.presentation.dto

import com.sr.solorecipe.domain.user.presentation.response.UserInfoRecipeResponse

data class UserInfoDto(
    val name: String,
    val likeRecipe: List<UserInfoRecipeDto>,
    val myRecipe: List<UserInfoRecipeDto>
)
