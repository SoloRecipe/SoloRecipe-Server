package com.sr.solorecipe.domain.auth.presentation.data.dto

import java.time.LocalDateTime

data class TokenDto(
    val accessToken: String,
    val refreshToken: String,
    val accessExpiredTime: LocalDateTime,
    val refreshExpiredTime: LocalDateTime
)
