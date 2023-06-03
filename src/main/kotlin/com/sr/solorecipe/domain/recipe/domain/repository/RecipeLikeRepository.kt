package com.sr.solorecipe.domain.recipe.domain.repository

import com.sr.solorecipe.domain.recipe.domain.entity.RecipeLike
import com.sr.solorecipe.domain.user.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeLikeRepository: JpaRepository<RecipeLike, Long> {
    fun findAllByUser(user: User): List<RecipeLike>
}