package com.sr.solorecipe.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.sr.solorecipe.global.error.ErrorCode
import com.sr.solorecipe.global.error.ErrorResponse
import org.springframework.http.MediaType
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class CustomAuthenticationEntryPoint(
    private val objectMapper: ObjectMapper
):AuthenticationEntryPoint {
    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        val errorCode = ErrorCode.UNAUTHORIZED
        val errorResponseEntityToJson = objectMapper.writeValueAsString(ErrorResponse(errorCode.status, errorCode.message))
        response.characterEncoding = "UTF-8"
        response.status = errorCode.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(errorResponseEntityToJson)
    }
}