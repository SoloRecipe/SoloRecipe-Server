package com.sr.solorecipe.domain.like.presentation

import com.sr.solorecipe.domain.like.service.DeleteLikeService
import com.sr.solorecipe.domain.like.service.PushLikeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/like")
class LikeController(
    private val pushLikeService: PushLikeService,
    private val deleteLikeService: DeleteLikeService
) {
    @PostMapping("/{recipe-idx}")
    fun pushLike(@PathVariable("recipe-idx")idx: Long): ResponseEntity<Void> {
        pushLikeService.push(idx)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @DeleteMapping("/{recipe-idx}")
    fun deleteLike(@PathVariable("recipe-idx")idx: Long): ResponseEntity<Void> {
        deleteLikeService.delete(idx)
        return ResponseEntity.noContent().build()
    }
}