package com.sr.solorecipe.domain.auth.service

import com.sr.solorecipe.domain.auth.presentation.data.dto.LoginDto
import com.sr.solorecipe.domain.auth.presentation.data.dto.TokenDto

interface LoginService {
    fun login(loginDto: LoginDto): TokenDto
}
