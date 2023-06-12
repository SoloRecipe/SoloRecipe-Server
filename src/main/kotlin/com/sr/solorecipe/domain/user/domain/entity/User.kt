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
    var nickname: String,
    @Column(nullable = false)
    var profileImg: String
): BaseIdEntity() {
    fun updateUserName(name: String) {
        this.nickname = name
    }
    fun updateProfileImg(profileImg: String) {
        this.profileImg = profileImg
    }
}