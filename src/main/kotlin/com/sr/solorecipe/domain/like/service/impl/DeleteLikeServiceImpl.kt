package com.sr.solorecipe.domain.like.service.impl

import com.sr.solorecipe.domain.like.domain.repository.LikeRepository
import com.sr.solorecipe.domain.like.service.DeleteLikeService
import org.springframework.stereotype.Service

@Service
class DeleteLikeServiceImpl(
    private val likeRepository: LikeRepository,
): DeleteLikeService {
    override fun delete(idx: Long) {
        val entity = likeRepository.findByRecipeIdx(idx)
        likeRepository.delete(entity)
    }
}