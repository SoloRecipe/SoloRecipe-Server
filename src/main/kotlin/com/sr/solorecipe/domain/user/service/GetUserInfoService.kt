package com.sr.solorecipe.domain.user.service

import com.sr.solorecipe.domain.user.presentation.dto.UserInfoDto

interface GetUserInfoService {
    fun getUserInfo(): UserInfoDto

}
