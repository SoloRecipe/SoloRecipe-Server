package com.sr.solorecipe.global.security.jwt.properties

import io.jsonwebtoken.security.Keys
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.nio.charset.StandardCharsets
import java.security.Key

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class JwtProperties(
    secret: String,
){
    val secret: Key

    init {
        this.secret = Keys.hmacShaKeyFor(secret.toByteArray(StandardCharsets.UTF_8))
    }
}