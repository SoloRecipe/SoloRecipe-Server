package com.sr.solorecipe.domain.image.util

import com.sr.solorecipe.domain.image.presentation.data.dto.ImagesDto
import com.sr.solorecipe.domain.image.presentation.data.dto.UploadImagesDto
import com.sr.solorecipe.domain.image.presentation.data.response.ImagesResponse
import org.springframework.web.multipart.MultipartFile

interface ImageConverter {
    fun toDto(files: List<MultipartFile>): UploadImagesDto
    fun toResponse(dto: ImagesDto): ImagesResponse
}