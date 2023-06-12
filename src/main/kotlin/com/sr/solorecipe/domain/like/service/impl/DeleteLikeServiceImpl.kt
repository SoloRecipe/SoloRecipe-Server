package com.sr.solorecipe.domain.like.service.impl

import com.sr.solorecipe.domain.like.domain.repository.LikeRepository
import com.sr.solorecipe.domain.like.service.DeleteLikeService
import com.sr.solorecipe.domain.user.util.UserUtil
import org.springframework.stereotype.Service

@Service
class DeleteLikeServiceImpl(
    private val likeRepository: LikeRepository,
    private val userUtil: UserUtil
): DeleteLikeService {
    override fun delete(idx: Long) {
        val currentUser = userUtil.currentUser()
        val entity = likeRepository.findByRecipeIdxAndUserIdx(idx, currentUser.idx)
        likeRepository.delete(entity)
    }
}