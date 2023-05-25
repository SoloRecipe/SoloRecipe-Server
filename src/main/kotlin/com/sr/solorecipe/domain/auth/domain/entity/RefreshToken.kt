package com.sr.solorecipe.domain.auth.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@RedisHash(value = "refresh_token", timeToLive = 60 * 60 * 24 * 7)
data class RefreshToken(
    @Id
    @Indexed
    val userIdx: Long,
    @Indexed
    val token: String
)
