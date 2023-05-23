package com.sr.solorecipe.global.security.jwt.properties

import io.jsonwebtoken.security.Keys
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.nio.charset.StandardCharsets
import java.security.Key

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class JwtProperties(
    accessToken: String,
    refreshToken: String
){
    val accessToken: Key
    val refreshToken: Key

    init {
        this.accessToken = Keys.hmacShaKeyFor(accessToken.toByteArray(StandardCharsets.UTF_8))
        this.refreshToken = Keys.hmacShaKeyFor(refreshToken.toByteArray(StandardCharsets.UTF_8))
    }
}