package com.sr.solorecipe.domain.review.domain.entity

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
data class Review(
    @Column(nullable = false)
    val content : String,
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    val user: User
):BaseIdEntity()
