package com.sr.solorecipe.domain.like.presentation

import com.sr.solorecipe.domain.like.service.PushLikeService
import jdk.jshell.Snippet.Status
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/like")
class LikeController(
    private val pushLikeService: PushLikeService
) {
    @PostMapping("/{recipe-idx}")
    fun pushLike(@PathVariable("recipe-idx")idx: Long): ResponseEntity<Void> {
        pushLikeService.push(idx)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}