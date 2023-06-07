package com.sr.solorecipe.domain.user.domain.entity

import com.sr.solorecipe.global.common.entity.BaseIdEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
data class User(
    @Column(nullable = false)
    val email: String,
    @Column(nullable = false)
    val password: String,
    @Column(nullable = false)
    val nickname: String,
    @Column(nullable = false)
    val profileImg: String
): BaseIdEntity()