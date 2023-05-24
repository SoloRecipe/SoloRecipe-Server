package com.sr.solorecipe.domain.auth.presentation

import com.sr.solorecipe.domain.auth.presentation.data.request.SignUpRequestDto
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
    private val signUpService: SignUpService
) {

    @PostMapping("/register")
    fun signUp(@RequestBody signUpRequestDto: SignUpRequestDto): ResponseEntity<Void> =
        authConverter.toDto(signUpRequestDto)
            .let { signUpService.signUp(it) }
            .let { ResponseEntity(HttpStatus.CREATED) }
}