package com.sr.solorecipe.domain.review.presentation

import com.sr.solorecipe.domain.review.presentation.request.UpdateReviewRequest
import com.sr.solorecipe.domain.review.presentation.request.WriteReviewRequest
import com.sr.solorecipe.domain.review.service.RemoveReviewService
import com.sr.solorecipe.domain.review.service.UpdateReviewService
import com.sr.solorecipe.domain.review.service.WriteReviewService
import com.sr.solorecipe.domain.review.util.ReviewConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/review")
class ReviewController(
    private val reviewConverter: ReviewConverter,
    private val writeReviewService: WriteReviewService,
    private val updateReviewService: UpdateReviewService,
    private val removeReviewService: RemoveReviewService
) {
    @PostMapping("/{recipe-idx}")
    fun writeReview(@PathVariable("recipe-idx")idx: Long, @RequestBody request: WriteReviewRequest): ResponseEntity<Void> {
        writeReviewService.write(idx, reviewConverter.toDto(request))
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
    @PatchMapping("/{review-idx}")
    fun updateReview(@PathVariable("review-idx")idx: Long, @RequestBody request: UpdateReviewRequest): ResponseEntity<Void> {
        updateReviewService.update(reviewConverter.toDto(request, idx))
        return ResponseEntity.noContent().build()
    }
    @DeleteMapping("/{review-idx}")
    fun removeReview(@PathVariable("review-idx")idx: Long): ResponseEntity<Void> {
        removeReviewService.remove(idx)
        return ResponseEntity.noContent().build()
    }
}