package com.sr.solorecipe.domain.user.presentation

import com.sr.solorecipe.domain.auth.domain.entity.RefreshToken
import com.sr.solorecipe.domain.user.presentation.request.UpdateUserNameRequest
import com.sr.solorecipe.domain.user.presentation.response.UserInfoResponse
import com.sr.solorecipe.domain.user.service.GetUserInfoService
import com.sr.solorecipe.domain.user.service.LogoutService
import com.sr.solorecipe.domain.user.service.UpdateUserNameService
import com.sr.solorecipe.domain.user.util.UserConverter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val getUserInfoService: GetUserInfoService,
    private val updateUserNameService: UpdateUserNameService,
    private val userConverter: UserConverter,
    private val logoutService: LogoutService
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
        updateUserNameService.updateUserName(userConverter.toDto(request))
        return ResponseEntity.noContent().build()
    }
    @DeleteMapping
    fun logoutUser(): ResponseEntity<Void> =
            logoutService.logoutUser()
                    .run { ResponseEntity.noContent().build() }
}