package com.sr.solorecipe.domain.review.service

import com.sr.solorecipe.domain.review.presentation.dto.UpdateReviewDto

interface UpdateReviewService {
    fun update(dto: UpdateReviewDto)
}