package com.sr.solorecipe.domain.user.service.impl

import com.sr.solorecipe.domain.user.presentation.dto.UpdateUserProfileImgDto
import com.sr.solorecipe.domain.user.service.UpdateUserProfileImgService
import com.sr.solorecipe.domain.user.util.UserUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UpdateUserProfileImgServiceImpl(
        private val userUtil: UserUtil
) : UpdateUserProfileImgService {
    override fun updateProfileImg(dto: UpdateUserProfileImgDto) {
        val currentUser = userUtil.currentUser()
        currentUser.updateProfileImg(dto.profileImg)
    }
}