package com.sr.solorecipe.domain.auth.service.impl

import com.sr.solorecipe.domain.auth.domain.repository.RefreshTokenRepository
import com.sr.solorecipe.domain.auth.presentation.data.dto.LoginDto
import com.sr.solorecipe.domain.auth.presentation.data.dto.TokenDto
import com.sr.solorecipe.domain.auth.service.LoginService
import com.sr.solorecipe.domain.auth.util.AuthConverter
import com.sr.solorecipe.domain.auth.exception.PasswordNotMatchException
import com.sr.solorecipe.domain.user.domain.entity.User
import com.sr.solorecipe.domain.user.domain.repository.UserRepository
import com.sr.solorecipe.domain.user.exception.UserNotFoundException
import com.sr.solorecipe.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class LoginServiceImpl(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtTokenProvider: JwtTokenProvider,
    private val authConverter: AuthConverter,
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
): LoginService {

    override fun login(loginDto: LoginDto): TokenDto {
        val user = userRepository.findByEmail(loginDto.email) ?: throw UserNotFoundException()
        checkPassword(user, loginDto.password)

        val accessToken = jwtTokenProvider.generateAccessToken(user.email)
        val refreshToken = jwtTokenProvider.generateRefreshToken(user.email)
        val accessExpiredTime = jwtTokenProvider.accessExpiredTime
        val refreshExpiredTime = jwtTokenProvider.refreshExpiredTime

        saveRefreshToken(refreshToken, user)

        return TokenDto(
            accessToken = accessToken,
            refreshToken = refreshToken,
            accessExp = accessExpiredTime,
            refreshExp = refreshExpiredTime
        )
    }

    private fun checkPassword(user: User, password: String) {
        if (!passwordEncoder.matches(password, user.password))
            throw PasswordNotMatchException()
    }

    private fun saveRefreshToken(refreshToken: String, user: User) {
        refreshTokenRepository.save(authConverter.toEntity(refreshToken, user.idx))
    }
}