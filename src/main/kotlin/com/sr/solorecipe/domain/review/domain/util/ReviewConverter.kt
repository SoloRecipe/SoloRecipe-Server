package com.sr.solorecipe.domain.review.domain.util

import com.sr.solorecipe.domain.review.domain.entity.Review
import com.sr.solorecipe.domain.review.domain.presentation.dto.ReviewDto
import com.sr.solorecipe.domain.review.domain.presentation.response.ReviewResponse

interface ReviewConverter {
    fun toDto(review: Review): ReviewDto
    fun toResponse(reviewDto: ReviewDto): ReviewResponse
}