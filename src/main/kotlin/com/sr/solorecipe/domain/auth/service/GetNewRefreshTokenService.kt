package com.sr.solorecipe.domain.auth.service

import com.sr.solorecipe.domain.auth.presentation.data.dto.TokenDto

interface GetNewRefreshTokenService {
    fun get(refreshToken: String): TokenDto
}
