package com.sr.solorecipe.domain.image.presentation.data.dto

import org.springframework.web.multipart.MultipartFile

data class UploadImagesDto (
    val images: List<MultipartFile>
)