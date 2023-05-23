package com.sr.solorecipe.global.error

enum class ErrorCode(
    val message: String,
    val status: Int
) {
    USER_NOT_FOUND("유저가 존재하지 않습니다.", 404),
}
