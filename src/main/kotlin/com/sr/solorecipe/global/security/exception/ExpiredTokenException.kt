package com.sr.solorecipe.global.security.exception

import com.sr.solorecipe.global.error.ErrorCode
import com.sr.solorecipe.global.error.exception.BasicException

class ExpiredTokenException : BasicException(ErrorCode.EXPIRED_TOKEN)
