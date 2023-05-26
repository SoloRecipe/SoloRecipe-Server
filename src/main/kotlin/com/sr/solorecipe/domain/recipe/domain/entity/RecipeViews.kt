package com.sr.solorecipe.domain.recipe.domain.entity

import com.sr.solorecipe.global.common.entity.BaseIdEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
data class RecipeViews(
    @Column(nullable = false)
    val views: String
): BaseIdEntity()
