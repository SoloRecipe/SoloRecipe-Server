package com.sr.solorecipe.domain.auth.util.impl

import com.sr.solorecipe.domain.auth.presentation.data.dto.SignUpDto
import com.sr.solorecipe.domain.auth.presentation.data.request.SignUpRequestDto
import com.sr.solorecipe.domain.auth.util.AuthConverter
import com.sr.solorecipe.domain.user.domain.entity.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class AuthConverterImpl(
    private val passwordEncoder: PasswordEncoder
): AuthConverter {

    override fun toDto(signUpRequestDto: SignUpRequestDto): SignUpDto =
        SignUpDto(
            email = signUpRequestDto.email,
            password = passwordEncoder.encode(signUpRequestDto.password),
            nickname = signUpRequestDto.nickname
        )

    override fun toEntity(signUpDto: SignUpDto): User =
        User(
            email = signUpDto.email,
            password = signUpDto.password,
            nickname = signUpDto.nickname
        )
}