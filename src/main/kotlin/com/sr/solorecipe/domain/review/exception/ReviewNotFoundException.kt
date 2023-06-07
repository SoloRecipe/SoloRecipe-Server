package com.sr.solorecipe.domain.review.exception

import com.sr.solorecipe.global.error.ErrorCode
import com.sr.solorecipe.global.error.exception.BasicException

class ReviewNotFoundException : BasicException(ErrorCode.REVIEW_NOT_FOUND)