package com.sr.solorecipe.domain.auth.service

import com.sr.solorecipe.domain.auth.presentation.data.dto.SignUpDto

interface SignUpService {
    fun signUp(signUpDto: SignUpDto)
}
