package com.sr.solorecipe.domain.auth.util

import com.sr.solorecipe.domain.auth.presentation.data.dto.SignUpDto
import com.sr.solorecipe.domain.auth.presentation.data.request.SignUpRequestDto
import com.sr.solorecipe.domain.user.domain.entity.User

interface AuthConverter {
    fun toDto(signUpRequestDto: SignUpRequestDto): SignUpDto
    fun toEntity(signUpDto: SignUpDto): User
}
