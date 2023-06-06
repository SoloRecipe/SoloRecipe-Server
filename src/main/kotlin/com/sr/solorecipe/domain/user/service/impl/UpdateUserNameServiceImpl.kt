package com.sr.solorecipe.domain.user.service.impl

import com.sr.solorecipe.domain.user.domain.repository.UserRepository
import com.sr.solorecipe.domain.user.presentation.dto.UpdateUserNameDto
import com.sr.solorecipe.domain.user.service.UpdateUserNameService
import com.sr.solorecipe.domain.user.util.UserUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UpdateUserNameServiceImpl(
        private val userUtil: UserUtil,
        private val userRepository: UserRepository
) : UpdateUserNameService {
    override fun updateUserName(dto: UpdateUserNameDto) {
        val currentUser = userUtil.currentUser()
        userRepository.save(currentUser.copy(nickname = dto.name))
    }
}