package com.sr.solorecipe.domain.user.service.impl

import com.sr.solorecipe.domain.like.domain.repository.LikeRepository
import com.sr.solorecipe.domain.recipe.domain.repository.RecipeRepository
import com.sr.solorecipe.domain.user.presentation.dto.UserInfoDto
import com.sr.solorecipe.domain.user.service.GetUserInfoService
import com.sr.solorecipe.domain.user.util.UserConverter
import com.sr.solorecipe.domain.user.util.UserUtil
import org.springframework.stereotype.Service

@Service
class GetUserInfoServiceImpl(
    private val recipeRepository: RecipeRepository,
    private val likeRepository: LikeRepository,
    private val userConverter: UserConverter,
    private val userUtil: UserUtil
): GetUserInfoService {
    override fun getUserInfo(): UserInfoDto {
        val user = userUtil.currentUser()
        val recipeLike = likeRepository.findAllByUser(user)
            .map { userConverter.toDto(it.recipe) }
            .sortedByDescending { it.idx }
        val myRecipe = recipeRepository.findAllByUser(user)
            .map { userConverter.toDto(it) }
            .sortedByDescending { it.idx }

        return userConverter.toDto(user, recipeLike, myRecipe)
    }

}