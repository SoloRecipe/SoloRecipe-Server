package com.sr.solorecipe.domain.review.util

import com.sr.solorecipe.domain.review.domain.entity.Review
import com.sr.solorecipe.domain.review.presentation.dto.ReviewDto
import com.sr.solorecipe.domain.review.presentation.response.ReviewResponse

interface ReviewConverter {
    fun toDto(review: Review): ReviewDto
    fun toResponse(reviewDto: ReviewDto): ReviewResponse
}