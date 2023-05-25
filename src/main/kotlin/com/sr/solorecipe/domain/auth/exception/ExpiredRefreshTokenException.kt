package com.sr.solorecipe.domain.auth.exception

import com.sr.solorecipe.global.error.ErrorCode
import com.sr.solorecipe.global.error.exception.BasicException

class ExpiredRefreshTokenException : BasicException(ErrorCode.EXPIRED_TOKEN) {

}
