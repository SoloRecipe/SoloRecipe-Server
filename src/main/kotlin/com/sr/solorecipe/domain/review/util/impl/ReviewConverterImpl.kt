package com.sr.solorecipe.domain.review.util.impl

import com.sr.solorecipe.domain.recipe.domain.entity.Recipe
import com.sr.solorecipe.domain.review.domain.entity.Review
import com.sr.solorecipe.domain.review.presentation.dto.ReviewDto
import com.sr.solorecipe.domain.review.presentation.dto.UpdateReviewDto
import com.sr.solorecipe.domain.review.presentation.dto.WriteReviewDto
import com.sr.solorecipe.domain.review.presentation.request.UpdateReviewRequest
import com.sr.solorecipe.domain.review.presentation.request.WriteReviewRequest
import com.sr.solorecipe.domain.review.presentation.response.ReviewResponse
import com.sr.solorecipe.domain.review.util.ReviewConverter
import org.springframework.stereotype.Component

@Component
class ReviewConverterImpl(

): ReviewConverter {
    override fun toDto(review: Review): ReviewDto =
        ReviewDto(
            userIdx = review.recipe.user.idx,
            userName = review.recipe.user.nickname,
            content = review.content
        )

    override fun toDto(request: UpdateReviewRequest, idx: Long): UpdateReviewDto =
            UpdateReviewDto(
                    reviewIdx = idx,
                    content = request.content
            )

    override fun toDto(request: WriteReviewRequest): WriteReviewDto =
        WriteReviewDto(
            content = request.content
        )

    override fun toResponse(reviewDto: ReviewDto): ReviewResponse =
        ReviewResponse(
            userIdx = reviewDto.userIdx,
            userName = reviewDto.userName,
            content = reviewDto.content
        )

    override fun toEntity(foundRecipe: Recipe, writeReviewDto: WriteReviewDto): Review =
        Review(
            content = writeReviewDto.content,
            recipe = foundRecipe
        )
}