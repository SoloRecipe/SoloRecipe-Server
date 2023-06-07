package com.sr.solorecipe.domain.review.service

import com.sr.solorecipe.domain.review.presentation.dto.WriteReviewDto

interface WriteReviewService {
    fun write(idx: Long, writeReviewDto: WriteReviewDto)
}
