package com.sr.solorecipe.domain.user.exception

import com.sr.solorecipe.global.error.ErrorCode
import com.sr.solorecipe.global.error.exception.BasicException

class RefreshTokenNotFoundException: BasicException(ErrorCode.REFRESH_TOKEN_NOT_FOUND)