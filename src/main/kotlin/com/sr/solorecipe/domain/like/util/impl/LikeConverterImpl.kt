package com.sr.solorecipe.domain.like.util.impl

import com.sr.solorecipe.domain.like.domain.entity.Like
import com.sr.solorecipe.domain.like.util.LikeConverter
import com.sr.solorecipe.domain.recipe.domain.entity.Recipe
import com.sr.solorecipe.domain.user.domain.entity.User
import org.springframework.stereotype.Component

@Component
class LikeConverterImpl: LikeConverter {
    override fun toEntity(foundRecipe: Recipe, currentUser: User): Like =
        Like(
            recipe = foundRecipe,
            user = currentUser
        )
}