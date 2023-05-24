package com.sr.solorecipe.global.error

enum class ErrorCode(
    val message: String,
    val status: Int
) {
    EXPIRED_TOKEN("만료된 토큰 입니다.", 401),
    UNAUTHORIZED("권함이 없습니다.",401),


    USER_NOT_FOUND("유저가 존재하지 않습니다.", 404),



    INTERNAL_SERVER_ERROR("서버에 문제가 발생했습니다.", 500),
}
