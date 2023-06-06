package com.sr.solorecipe.domain.user.service

import com.sr.solorecipe.domain.user.presentation.dto.UpdateUserNameDto

interface UpdateUserNameService {
    fun updateUserName(dto: UpdateUserNameDto)
}