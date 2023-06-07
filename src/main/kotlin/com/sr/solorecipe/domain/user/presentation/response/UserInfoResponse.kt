package com.sr.solorecipe.domain.user.presentation.response


data class UserInfoResponse(
    val name: String,
    val profileImg: String,
    val likeRecipe: List<UserInfoRecipeResponse>,
    val myRecipe: List<UserInfoRecipeResponse>
)
