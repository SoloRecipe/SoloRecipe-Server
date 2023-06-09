package com.sr.solorecipe.domain.review.presentation.response

data class ReviewResponse(
    val userIdx: Long,
    val userName: String,
    val userProfileImage: String,
    val content: String
)
