package com.sr.solorecipe.domain.recipe.domain.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.sr.solorecipe.domain.user.domain.entity.User
import com.sr.solorecipe.global.common.entity.BaseIdEntity
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Entity
data class Recipe(
    @Column(nullable = false)
    val name : String,
    @Column(nullable = false)
    val thumbnail : String,
    @Column(nullable = false, name = "count_likes")
    val countLikes : Long,
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    val user : User
):BaseIdEntity()