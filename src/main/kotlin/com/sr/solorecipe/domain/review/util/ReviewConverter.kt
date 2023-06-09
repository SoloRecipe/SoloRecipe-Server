package com.sr.solorecipe.domain.review.util

import com.sr.solorecipe.domain.recipe.domain.entity.Recipe
import com.sr.solorecipe.domain.review.domain.entity.Review
import com.sr.solorecipe.domain.review.presentation.dto.ReviewDto
import com.sr.solorecipe.domain.review.presentation.dto.UpdateReviewDto
import com.sr.solorecipe.domain.review.presentation.dto.WriteReviewDto
import com.sr.solorecipe.domain.review.presentation.request.UpdateReviewRequest
import com.sr.solorecipe.domain.review.presentation.request.WriteReviewRequest
import com.sr.solorecipe.domain.review.presentation.response.ReviewResponse
import com.sr.solorecipe.domain.user.domain.entity.User

interface ReviewConverter {
    fun toDto(review: Review): ReviewDto
    fun toDto(request: UpdateReviewRequest, idx: Long): UpdateReviewDto
    fun toResponse(reviewDto: ReviewDto): ReviewResponse
    fun toDto(request: WriteReviewRequest): WriteReviewDto
    fun toEntity(currentUser: User, foundRecipe: Recipe, writeReviewDto: WriteReviewDto): Review
}