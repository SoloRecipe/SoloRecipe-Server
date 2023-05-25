package com.sr.solorecipe.domain.auth.presentation.data.response

import java.time.LocalDateTime

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val accessExpiredTime: LocalDateTime,
    val refreshExpiredTime: LocalDateTime
)
