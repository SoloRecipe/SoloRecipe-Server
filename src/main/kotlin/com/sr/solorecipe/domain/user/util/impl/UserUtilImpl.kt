package com.sr.solorecipe.domain.user.util.impl

import com.sr.solorecipe.domain.user.domain.entity.User
import com.sr.solorecipe.domain.user.domain.repository.UserRepository
import com.sr.solorecipe.domain.user.exception.UserNotFoundException
import com.sr.solorecipe.domain.user.util.UserUtil
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserUtilImpl(
    private val userRepository: UserRepository
): UserUtil {
    override fun currentUser(): User {
        val email = SecurityContextHolder.getContext().authentication.name
        return userRepository.findByEmail(email) ?: throw UserNotFoundException()
    }
}