package com.sr.solorecipe.domain.user.util

import com.sr.solorecipe.domain.user.domain.entity.User

interface UserUtil {
    fun currentUser(): User
}
