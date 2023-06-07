package com.sr.solorecipe.domain.auth.domain.repository

import com.sr.solorecipe.domain.auth.domain.entity.RefreshToken
import org.springframework.data.jpa.repository.JpaRepository

interface RefreshTokenRepository: JpaRepository<RefreshToken, Long> {
    fun findByToken(token: String): RefreshToken?
    fun findByUserIdx(idx: Long): RefreshToken?
}