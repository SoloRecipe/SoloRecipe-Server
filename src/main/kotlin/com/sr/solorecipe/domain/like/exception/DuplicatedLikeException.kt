package com.sr.solorecipe.domain.like.exception

import com.sr.solorecipe.global.error.ErrorCode
import com.sr.solorecipe.global.error.exception.BasicException

class DuplicatedLikeException : BasicException(ErrorCode.DUPLICATED_LIKE)
