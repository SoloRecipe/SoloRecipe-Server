package com.sr.solorecipe.domain.image.util.impl

import com.sr.solorecipe.domain.image.presentation.data.dto.ImagesDto
import com.sr.solorecipe.domain.image.presentation.data.dto.UploadImagesDto
import com.sr.solorecipe.domain.image.presentation.data.response.ImagesResponse
import com.sr.solorecipe.domain.image.util.ImageConverter
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile

@Component
class ImageConverterImpl : ImageConverter {
    override fun toDto(files: List<MultipartFile>): UploadImagesDto =
        UploadImagesDto(images = files)

    override fun toResponse(dto: ImagesDto): ImagesResponse =
        ImagesResponse(images = dto.images)
}