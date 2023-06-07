package com.sr.solorecipe.domain.review.service.impl

import com.sr.solorecipe.domain.recipe.domain.repository.RecipeRepository
import com.sr.solorecipe.domain.recipe.exception.RecipeNotFoundException
import com.sr.solorecipe.domain.review.domain.repository.ReviewRepository
import com.sr.solorecipe.domain.review.presentation.dto.WriteReviewDto
import com.sr.solorecipe.domain.review.service.WriteReviewService
import com.sr.solorecipe.domain.review.util.ReviewConverter
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional(rollbackOn = [Exception::class])
class WriteReviewServiceImpl(
    private val reviewRepository: ReviewRepository,
    private val recipeRepository: RecipeRepository,
    private val reviewConverter: ReviewConverter
): WriteReviewService {
    override fun write(idx: Long, writeReviewDto: WriteReviewDto) {
        val foundRecipe = recipeRepository.findById(idx)
            .orElseGet { throw RecipeNotFoundException() }
        val review = reviewConverter.toEntity(foundRecipe, writeReviewDto)
        reviewRepository.save(review)
    }
}