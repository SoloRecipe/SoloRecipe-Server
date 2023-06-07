package com.sr.solorecipe.domain.user.service

import com.sr.solorecipe.domain.user.presentation.dto.UpdateUserProfileImgDto

interface UpdateUserProfileImgService {
    fun updateProfileImg(dto: UpdateUserProfileImgDto)
}