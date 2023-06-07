package com.sr.solorecipe.domain.image.exception

import com.sr.solorecipe.global.error.ErrorCode
import com.sr.solorecipe.global.error.exception.BasicException

class FailUploadImageException : BasicException(ErrorCode.INTERNAL_SERVER_ERROR)