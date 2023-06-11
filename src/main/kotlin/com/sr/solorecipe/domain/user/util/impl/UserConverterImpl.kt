package com.sr.solorecipe.domain.user.util.impl

import com.sr.solorecipe.domain.recipe.domain.entity.Recipe
import com.sr.solorecipe.domain.user.domain.entity.User
import com.sr.solorecipe.domain.user.presentation.dto.UpdateUserNameDto
import com.sr.solorecipe.domain.user.presentation.dto.UpdateUserProfileImgDto
import com.sr.solorecipe.domain.user.presentation.dto.UserInfoDto
import com.sr.solorecipe.domain.user.presentation.dto.UserInfoRecipeDto
import com.sr.solorecipe.domain.user.presentation.request.UpdateUserNameRequest
import com.sr.solorecipe.domain.user.presentation.request.UpdateUserProfileImgRequest
import com.sr.solorecipe.domain.user.presentation.response.UserInfoRecipeResponse
import com.sr.solorecipe.domain.user.presentation.response.UserInfoResponse
import com.sr.solorecipe.domain.user.util.UserConverter
import org.springframework.stereotype.Component

@Component
class UserConverterImpl: UserConverter {
    override fun toDto(recipe: Recipe): UserInfoRecipeDto =
        UserInfoRecipeDto(
            idx = recipe.idx,
            name = recipe.name,
            thumbnail = recipe.thumbnail
        )

    override fun toDto(request: UpdateUserNameRequest): UpdateUserNameDto =
            UpdateUserNameDto(
                    name = request.name
            )

    override fun toDto(request: UpdateUserProfileImgRequest): UpdateUserProfileImgDto =
        UpdateUserProfileImgDto(
                profileImg = request.profileImg
        )


    override fun toDto(user: User, likeRecipe: List<UserInfoRecipeDto>, myRecipe: List<UserInfoRecipeDto>): UserInfoDto =
        UserInfoDto(
            name = user.nickname,
            profileImg = user.profileImg,
            likeRecipe = likeRecipe,
            myRecipe = myRecipe
        )

    override fun toResponse(userInfoRecipeDto: UserInfoRecipeDto): UserInfoRecipeResponse =
        UserInfoRecipeResponse(
            idx = userInfoRecipeDto.idx,
            name = userInfoRecipeDto.name,
            thumbnail = userInfoRecipeDto.thumbnail
        )

    override fun toResponse(dto: UserInfoDto, likeRecipe: List<UserInfoRecipeResponse>, myRecipe: List<UserInfoRecipeResponse>): UserInfoResponse =
        UserInfoResponse(
            name = dto.name,
            profileImg = dto.profileImg,
            likeRecipe = likeRecipe,
            myRecipe = myRecipe
        )
}