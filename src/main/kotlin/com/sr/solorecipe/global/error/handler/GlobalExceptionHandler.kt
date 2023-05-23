package com.sr.solorecipe.global.error.handler

import com.sr.solorecipe.global.error.ErrorCode
import com.sr.solorecipe.global.error.ErrorResponse
import com.sr.solorecipe.global.error.exception.BasicException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(BasicException::class)
    fun handleGlobalException(e: BasicException): ResponseEntity<ErrorResponse>{
        val errorCode: ErrorCode = e.errorCode;
        return ResponseEntity(
            ErrorResponse(status = errorCode.status, message = errorCode.message),
            HttpStatus.valueOf(errorCode.status)
        )
    }
}