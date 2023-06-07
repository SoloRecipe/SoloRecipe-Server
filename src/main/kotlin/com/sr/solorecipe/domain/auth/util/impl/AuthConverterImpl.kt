package com.sr.solorecipe.domain.auth.util.impl

import com.sr.solorecipe.domain.auth.domain.entity.RefreshToken
import com.sr.solorecipe.domain.auth.presentation.data.dto.LoginDto
import com.sr.solorecipe.domain.auth.presentation.data.dto.SignUpDto
import com.sr.solorecipe.domain.auth.presentation.data.dto.TokenDto
import com.sr.solorecipe.domain.auth.presentation.data.request.LoginRequest
import com.sr.solorecipe.domain.auth.presentation.data.request.SignUpRequest
import com.sr.solorecipe.domain.auth.presentation.data.response.TokenResponse
import com.sr.solorecipe.domain.auth.util.AuthConverter
import com.sr.solorecipe.domain.user.domain.entity.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class AuthConverterImpl(
    private val passwordEncoder: PasswordEncoder
): AuthConverter {

    override fun toDto(signUpRequestDto: SignUpRequest): SignUpDto =
        SignUpDto(
            email = signUpRequestDto.email,
            password = passwordEncoder.encode(signUpRequestDto.password),
            nickname = signUpRequestDto.nickname
        )

    override fun toDto(loginRequestDto: LoginRequest): LoginDto =
        LoginDto(
            email = loginRequestDto.email,
            password = loginRequestDto.password
        )

    override fun toEntity(signUpDto: SignUpDto): User =
        User(
            email = signUpDto.email,
            password = signUpDto.password,
            nickname = signUpDto.nickname,
            profileImg =  ""
        )

    override fun toEntity(refreshToken: String, userIdx: Long): RefreshToken =
        RefreshToken(
            userIdx = userIdx,
            token = refreshToken
        )

    override fun toResponse(tokenDto: TokenDto): TokenResponse =
        TokenResponse(
            accessToken = tokenDto.accessToken,
            refreshToken = tokenDto.refreshToken,
            accessExp = tokenDto.accessExp,
            refreshExp = tokenDto.refreshExp
        )
}