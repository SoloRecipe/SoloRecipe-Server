package com.sr.solorecipe.domain.review.service.impl

import com.sr.solorecipe.domain.review.domain.repository.ReviewRepository
import com.sr.solorecipe.domain.review.exception.ReviewNotFoundException
import com.sr.solorecipe.domain.review.service.RemoveReviewService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class RemoveReviewServiceImpl(
        private val reviewRepository: ReviewRepository
) : RemoveReviewService {
    override fun remove(idx: Long) {
        val review = reviewRepository.findById(idx)
                .orElseThrow { throw ReviewNotFoundException() }
        reviewRepository.delete(review)
    }
}