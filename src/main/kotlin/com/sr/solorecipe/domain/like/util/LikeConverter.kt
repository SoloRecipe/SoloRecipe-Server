package com.sr.solorecipe.domain.like.util

import com.sr.solorecipe.domain.like.domain.entity.Like
import com.sr.solorecipe.domain.recipe.domain.entity.Recipe
import com.sr.solorecipe.domain.user.domain.entity.User

interface LikeConverter {
    fun toEntity(foundRecipe: Recipe, currentUser: User): Like
}