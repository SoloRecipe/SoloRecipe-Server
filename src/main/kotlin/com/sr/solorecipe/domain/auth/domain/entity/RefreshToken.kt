package com.sr.solorecipe.domain.auth.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash(value = "refresh_token", timeToLive = 60 * 60 * 24 * 7)
data class RefreshToken(
    @Id
    val userIdx: Long,
    val token: String
)
