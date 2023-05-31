package com.sr.solorecipe.domain.review.domain.presentation.dto

data class ReviewDto (
    val userIdx: Long,
    val userName: String,
    val content: String
)