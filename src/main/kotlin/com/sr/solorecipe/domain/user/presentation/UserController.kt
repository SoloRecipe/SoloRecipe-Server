package com.sr.solorecipe.domain.user.presentation

import com.sr.solorecipe.domain.user.presentation.request.UpdateUserNameRequest
import com.sr.solorecipe.domain.user.presentation.response.UserInfoResponse
import com.sr.solorecipe.domain.user.service.GetUserInfoService
import com.sr.solorecipe.domain.user.util.UserConverter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val getUserInfoService: GetUserInfoService,
    private val userConverter: UserConverter,
) {
    @GetMapping
    fun getUserInfo(): ResponseEntity<UserInfoResponse> {
        val userInfoDto = getUserInfoService.getUserInfo()
        val likeRecipe = userInfoDto.likeRecipe
            .map(userConverter::toResponse)
        val myRecipe = userInfoDto.myRecipe
            .map(userConverter::toResponse)

        return ResponseEntity.ok(userConverter.toResponse(userInfoDto.name, likeRecipe, myRecipe))
    }
    @PatchMapping
    fun updateUserName(@RequestBody request: UpdateUserNameRequest): ResponseEntity<Void> {
        return ResponseEntity.noContent().build()
    }
}