package com.sr.solorecipe.domain.auth.service.impl

import com.sr.solorecipe.domain.auth.presentation.data.dto.SignUpDto
import com.sr.solorecipe.domain.auth.service.SignUpService
import com.sr.solorecipe.domain.auth.util.AuthConverter
import com.sr.solorecipe.domain.exception.DuplicatedEmailException
import com.sr.solorecipe.domain.exception.DuplicatedNicknameException
import com.sr.solorecipe.domain.user.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class SignUpServiceImpl(
    private val authConverter: AuthConverter,
    private val userRepository: UserRepository
): SignUpService {

    override fun signUp(signUpDto: SignUpDto) {
        if(userRepository.existsByEmail(signUpDto.email))
            throw DuplicatedEmailException()
        if(userRepository.existsByNickname(signUpDto.nickname))
            throw DuplicatedNicknameException()

        val user = authConverter.toEntity(signUpDto)
        userRepository.save(user)
    }
}