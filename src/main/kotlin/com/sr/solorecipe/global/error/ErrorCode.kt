package com.sr.solorecipe.global.error

enum class ErrorCode(
    val message: String,
    val status: Int
) {
    PASSWORD_NOT_MATCH("비밀번호가 옳지 않습니다.", 400),


    EXPIRED_TOKEN("만료된 토큰 입니다.", 401),
    UNAUTHORIZED("권한이 없습니다.",401),


    USER_NOT_FOUND("유저가 존재하지 않습니다.", 404),
    RECIPE_NOT_FOUND("레시피가 존재하지 않습니다.", 404),


    DUPLICATED_EMAIL("이미 존재하는 이메일입니다.", 409),
    DUPLICATED_NICKNAME("이미 존재하는 닉네임입니다.", 409),

    INTERNAL_SERVER_ERROR("서버에 문제가 발생했습니다.", 500),
}
