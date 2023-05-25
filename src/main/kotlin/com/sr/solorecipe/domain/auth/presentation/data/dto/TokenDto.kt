package com.sr.solorecipe.domain.auth.presentation.data.dto

import java.time.LocalDateTime

data class TokenDto(
    val accessToken: String,
    val refreshToken: String,
    val accessExp: LocalDateTime,
    val refreshExp: LocalDateTime
)
