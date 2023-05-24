package com.sr.solorecipe.global.error.exception

import com.sr.solorecipe.global.error.ErrorCode

open class BasicException(val errorCode: ErrorCode): RuntimeException()