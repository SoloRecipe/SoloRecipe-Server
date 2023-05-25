package com.sr.solorecipe.domain.auth.presentation

import com.sr.solorecipe.domain.auth.presentation.data.request.LoginRequest
import com.sr.solorecipe.domain.auth.presentation.data.request.SignUpRequest
import com.sr.solorecipe.domain.auth.presentation.data.response.TokenResponse
import com.sr.solorecipe.domain.auth.service.LoginService
import com.sr.solorecipe.domain.auth.service.SignUpService
import com.sr.solorecipe.domain.auth.util.AuthConverter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authConverter: AuthConverter,
    private val signUpService: SignUpService,
    private val loginService: LoginService,
) {

    @PostMapping("/register")
    fun signUp(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<Void> =
        authConverter.toDto(signUpRequest)
            .let { signUpService.signUp(it) }
            .let { ResponseEntity(HttpStatus.CREATED) }

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<TokenResponse> =
        authConverter.toDto(loginRequest)
            .let { ResponseEntity.ok(authConverter.toResponse(loginService.login(it))) }

}