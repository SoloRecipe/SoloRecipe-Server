package com.sr.solorecipe.domain.user.service.impl

import com.sr.solorecipe.domain.auth.domain.entity.RefreshToken
import com.sr.solorecipe.domain.auth.domain.repository.RefreshTokenRepository
import com.sr.solorecipe.domain.user.exception.UserNotFoundException
import com.sr.solorecipe.domain.user.service.LogoutService
import com.sr.solorecipe.domain.user.util.UserUtil
import org.springframework.stereotype.Service

@Service
class LogoutServiceImpl(
    private val userUtil: UserUtil,
    private val refreshTokenRepository: RefreshTokenRepository
) : LogoutService {
    override fun logoutUser() {
        val currentUser = userUtil.currentUser()
        val refreshToken = (refreshTokenRepository.findByUserIdx(currentUser.idx) ?: UserNotFoundException()) as RefreshToken
        refreshTokenRepository.delete(refreshToken)
    }
}