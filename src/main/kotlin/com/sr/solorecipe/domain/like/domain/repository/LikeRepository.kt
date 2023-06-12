package com.sr.solorecipe.domain.like.domain.repository

import com.sr.solorecipe.domain.like.domain.entity.Like
import com.sr.solorecipe.domain.user.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface LikeRepository: JpaRepository<Like, Long> {
    fun findAllByUser(user: User): List<Like>
    fun findByRecipeIdx(idx: Long): Like
    fun existsByRecipeIdxAndUserIdx(recipeIdx: Long, userIdx: Long): Boolean
}