package com.sr.solorecipe.domain.image.presentation

import com.sr.solorecipe.domain.image.presentation.data.response.ImagesResponse
import com.sr.solorecipe.domain.image.service.UploadImageService
import com.sr.solorecipe.domain.image.util.ImageConverter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid

@RestController
@RequestMapping("/image")
class ImageController(
        private val imageConverter: ImageConverter,
        private val uploadImageService: UploadImageService
) {
    @PostMapping
    fun uploadFile(@Valid @RequestPart(value = "file") multipartFile: List<MultipartFile>): ResponseEntity<ImagesResponse> =
                  imageConverter.toDto(multipartFile)
                    .let { uploadImageService.execute(it) }
                    .let { imageConverter.toResponse(it) }
                    .let { ResponseEntity.ok().body(it) }

}