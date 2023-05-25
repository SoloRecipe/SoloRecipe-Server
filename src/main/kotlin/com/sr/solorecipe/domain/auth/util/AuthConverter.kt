package com.sr.solorecipe.domain.auth.util

import com.sr.solorecipe.domain.auth.domain.entity.RefreshToken
import com.sr.solorecipe.domain.auth.presentation.data.dto.LoginDto
import com.sr.solorecipe.domain.auth.presentation.data.dto.SignUpDto
import com.sr.solorecipe.domain.auth.presentation.data.dto.TokenDto
import com.sr.solorecipe.domain.auth.presentation.data.request.LoginRequest
import com.sr.solorecipe.domain.auth.presentation.data.request.SignUpRequest
import com.sr.solorecipe.domain.auth.presentation.data.response.TokenResponse
import com.sr.solorecipe.domain.user.domain.entity.User

interface AuthConverter {
    fun toDto(signUpRequestDto: SignUpRequest): SignUpDto
    fun toEntity(signUpDto: SignUpDto): User
    fun toEntity(refreshToken: String, userIdx: Long): RefreshToken
    fun toDto(loginRequestDto: LoginRequest): LoginDto
    fun toResponse(tokenDto: TokenDto): TokenResponse
}
