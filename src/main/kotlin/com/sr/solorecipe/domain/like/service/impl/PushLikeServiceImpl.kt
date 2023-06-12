package com.sr.solorecipe.domain.like.service.impl

import com.sr.solorecipe.domain.like.domain.repository.LikeRepository
import com.sr.solorecipe.domain.like.exception.DuplicatedLikeException
import com.sr.solorecipe.domain.like.service.PushLikeService
import com.sr.solorecipe.domain.like.util.LikeConverter
import com.sr.solorecipe.domain.recipe.domain.repository.RecipeRepository
import com.sr.solorecipe.domain.recipe.exception.RecipeNotFoundException
import com.sr.solorecipe.domain.user.util.UserUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(rollbackFor =[Exception::class])
class PushLikeServiceImpl(
    private val likeRepository: LikeRepository,
    private val recipeRepository: RecipeRepository,
    private val likeConverter: LikeConverter,
    private val userUtil: UserUtil
): PushLikeService {
    override fun push(idx: Long) {
        val currentUser = userUtil.currentUser()
        val foundRecipe = recipeRepository.findById(idx)
            .orElseThrow{ throw RecipeNotFoundException() }
        val likeEntity = likeConverter.toEntity(foundRecipe, currentUser)

        if(likeRepository.existsByRecipeIdxAndUserIdx(foundRecipe.idx, currentUser.idx))
            throw DuplicatedLikeException()
        likeRepository.save(likeEntity)
    }

}