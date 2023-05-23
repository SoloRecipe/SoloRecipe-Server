package com.sr.solorecipe.domain.user.exception

import com.sr.solorecipe.global.error.ErrorCode
import com.sr.solorecipe.global.error.exception.BasicException

class UserNotFoundException: BasicException(ErrorCode.USER_NOT_FOUND)