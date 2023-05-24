package com.sr.solorecipe.domain.exception

import com.sr.solorecipe.global.error.ErrorCode
import com.sr.solorecipe.global.error.exception.BasicException

class DuplicatedEmailException : BasicException(ErrorCode.DUPLICATED_EMAIL)
