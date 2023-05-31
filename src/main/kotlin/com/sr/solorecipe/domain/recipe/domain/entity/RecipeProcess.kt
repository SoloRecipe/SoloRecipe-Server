package com.sr.solorecipe.domain.recipe.domain.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.sr.solorecipe.global.common.entity.BaseIdEntity
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Entity
data class RecipeProcess(
    @Column(nullable = false)
    val description: String,
    @Column(nullable = false)
    val image: String,
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    val recipe: Recipe
):BaseIdEntity()
