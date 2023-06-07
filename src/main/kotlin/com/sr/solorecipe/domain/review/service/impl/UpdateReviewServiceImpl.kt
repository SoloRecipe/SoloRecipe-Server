package com.sr.solorecipe.domain.review.service.impl

import com.sr.solorecipe.domain.review.exception.ReviewNotFoundException
import com.sr.solorecipe.domain.review.domain.repository.ReviewRepository
import com.sr.solorecipe.domain.review.presentation.dto.UpdateReviewDto
import com.sr.solorecipe.domain.review.service.UpdateReviewService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UpdateReviewServiceImpl(
        private val reviewRepository: ReviewRepository,
) : UpdateReviewService {
    override fun update(dto: UpdateReviewDto) {
        val review = reviewRepository.findById(dto.reviewIdx)
                .orElseThrow{ throw ReviewNotFoundException() }
        reviewRepository.save(review.copy(content = dto.content))
    }
}