package com.sr.solorecipe.domain.user.util

import com.sr.solorecipe.domain.recipe.domain.entity.Recipe
import com.sr.solorecipe.domain.user.domain.entity.User
import com.sr.solorecipe.domain.user.presentation.dto.UpdateUserNameDto
import com.sr.solorecipe.domain.user.presentation.dto.UserInfoDto
import com.sr.solorecipe.domain.user.presentation.dto.UserInfoRecipeDto
import com.sr.solorecipe.domain.user.presentation.request.UpdateUserNameRequest
import com.sr.solorecipe.domain.user.presentation.response.UserInfoRecipeResponse
import com.sr.solorecipe.domain.user.presentation.response.UserInfoResponse

interface UserConverter {
    fun toDto(recipe: Recipe): UserInfoRecipeDto
    fun toDto(request: UpdateUserNameRequest): UpdateUserNameDto
    fun toDto(user: User, likeRecipe: List<UserInfoRecipeDto>, myRecipe: List<UserInfoRecipeDto>): UserInfoDto
    fun toResponse(userInfoRecipeDto: UserInfoRecipeDto): UserInfoRecipeResponse
    fun toResponse(name: String, likeRecipe: List<UserInfoRecipeResponse>, myRecipe: List<UserInfoRecipeResponse>): UserInfoResponse
}