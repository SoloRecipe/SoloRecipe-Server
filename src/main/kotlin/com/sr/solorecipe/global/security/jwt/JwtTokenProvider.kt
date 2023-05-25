package com.sr.solorecipe.global.security.jwt

import com.sr.solorecipe.global.security.authentication.AuthDetailsService
import com.sr.solorecipe.global.security.exception.ExpiredTokenException
import com.sr.solorecipe.global.security.exception.InvalidTokenException
import com.sr.solorecipe.global.security.jwt.properties.JwtProperties
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.security.Key
import java.time.LocalDateTime
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService
) {
    private val ACCESS_TOKEN_EXPIRED_TIME: Long = 60 * 15
    private val REFRESH_TOKEN_EXPIRED_TIME: Long = 60 * 60 * 24 * 7

    enum class TokenType(val value: String) {
        ACCESS_TOKEN("accessToken"),
        REFRESH_TOKEN("refreshToken")
    }
    val accessExpiredTime: LocalDateTime
        get() = LocalDateTime.now().plusSeconds(ACCESS_TOKEN_EXPIRED_TIME)

    val refreshExpiredTime: LocalDateTime
        get() = LocalDateTime.now().plusSeconds(REFRESH_TOKEN_EXPIRED_TIME)

    fun generateAccessToken(email: String): String = createToken(email, TokenType.ACCESS_TOKEN)

    fun generateRefreshToken(email: String): String = createToken(email, TokenType.REFRESH_TOKEN)


    fun authentication(token: String): Authentication {
        val userDetails: UserDetails = authDetailsService.loadUserByUsername(getTokenSubject(token))
        return UsernamePasswordAuthenticationToken(userDetails,"",userDetails.authorities)
    }

    fun getTokenSubject(token: String): String {
        return getTokenBody(token).subject
    }

    fun resolveToken(req: HttpServletRequest): String? {
        val token = req.getHeader("Authorization") ?: return null
        return if (token.startsWith("Bearer ")) token.replace("Bearer ", "") else null
    }

    private fun getTokenBody(token: String): Claims {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(jwtProperties.secret)
                .build()
                .parseClaimsJws(token)
                .body
        } catch (e: ExpiredJwtException) {
            throw ExpiredTokenException()
        } catch (e: Exception) {
            throw InvalidTokenException()
        }
    }

    private fun createToken(email: String, tokenType: TokenType): String {
        return Jwts.builder()
            .signWith(jwtProperties.secret, SignatureAlgorithm.HS256)
            .claim("email", email)
            .claim("type", tokenType)
            .setIssuedAt(Date())
            .setSubject(email)
            .setExpiration(Date(System.currentTimeMillis() + getTokenExpiredTime(tokenType) * 1000))
            .compact()
    }

    private fun getTokenExpiredTime(tokenType: TokenType): Long =
        if (tokenType == TokenType.ACCESS_TOKEN) ACCESS_TOKEN_EXPIRED_TIME
        else REFRESH_TOKEN_EXPIRED_TIME

}