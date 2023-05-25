package com.sr.solorecipe.domain.auth.service.impl

import com.sr.solorecipe.domain.auth.domain.repository.RefreshTokenRepository
import com.sr.solorecipe.domain.auth.exception.ExpiredRefreshTokenException
import com.sr.solorecipe.domain.auth.presentation.data.dto.TokenDto
import com.sr.solorecipe.domain.auth.service.GetNewRefreshTokenService
import com.sr.solorecipe.domain.auth.util.AuthConverter
import com.sr.solorecipe.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Service

@Service
class GetNewRefreshTokenServiceImpl(
    private val jwtTokenProvider: JwtTokenProvider,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val authConverter: AuthConverter
): GetNewRefreshTokenService {
    override fun get(refreshToken: String): TokenDto {
        val existingRefreshToken = refreshTokenRepository.findByToken(refreshToken)
            ?: throw ExpiredRefreshTokenException()
        val email = jwtTokenProvider.getTokenSubject(refreshToken)

        val newAccessToken  = jwtTokenProvider.generateAccessToken(email)
        val newRefreshToken = jwtTokenProvider.generateRefreshToken(email)
        val newAccessExpiredTime = jwtTokenProvider.accessExpiredTime
        val newRefreshExpiredTime = jwtTokenProvider.refreshExpiredTime

        saveRefreshToken(refreshToken, existingRefreshToken.userIdx)

        return TokenDto(
            accessToken = newAccessToken,
            refreshToken = newRefreshToken,
            accessExp = newAccessExpiredTime,
            refreshExp = newRefreshExpiredTime
        )
    }

    private fun saveRefreshToken(refreshToken: String, userIdx: Long) =
        refreshTokenRepository.save(authConverter.toEntity(refreshToken, userIdx))

}