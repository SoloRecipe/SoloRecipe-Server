package com.sr.solorecipe.domain.review.presentation.dto

data class ReviewDto (
    val userIdx: Long,
    val userName: String,
    val content: String
)