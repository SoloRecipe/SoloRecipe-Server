package com.sr.solorecipe.domain.exception

import com.sr.solorecipe.global.error.ErrorCode
import com.sr.solorecipe.global.error.exception.BasicException

class DuplicatedNicknameException : BasicException(ErrorCode.DUPLICATED_NICKNAME)
