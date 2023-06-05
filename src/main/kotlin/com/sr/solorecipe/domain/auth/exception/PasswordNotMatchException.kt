package com.sr.solorecipe.domain.auth.exception

import com.sr.solorecipe.global.error.ErrorCode
import com.sr.solorecipe.global.error.exception.BasicException

class PasswordNotMatchException() : BasicException(ErrorCode.PASSWORD_NOT_MATCH) {

}
