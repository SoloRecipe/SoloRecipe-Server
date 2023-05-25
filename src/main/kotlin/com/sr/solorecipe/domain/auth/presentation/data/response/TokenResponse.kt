package com.sr.solorecipe.domain.auth.presentation.data.response

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    @JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    val accessExp: LocalDateTime,
    @JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss")
    val refreshExp: LocalDateTime
)
