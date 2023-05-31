package com.sr.solorecipe.domain.review.domain.repository

import com.sr.solorecipe.domain.review.domain.entity.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository: JpaRepository<Review, Long> {
    fun findAllByRecipeIdx(idx: Long): List<Review>
}