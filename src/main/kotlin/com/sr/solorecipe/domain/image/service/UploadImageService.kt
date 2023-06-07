package com.sr.solorecipe.domain.image.service

import com.sr.solorecipe.domain.image.presentation.data.dto.ImagesDto
import com.sr.solorecipe.domain.image.presentation.data.dto.UploadImagesDto

interface UploadImageService {
    fun execute(dto: UploadImagesDto): ImagesDto
}