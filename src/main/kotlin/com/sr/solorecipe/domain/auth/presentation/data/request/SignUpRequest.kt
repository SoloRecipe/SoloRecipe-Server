package com.sr.solorecipe.domain.auth.presentation.data.request

data class SignUpRequest(
    val email: String,
    val password: String,
    val nickname: String
)
