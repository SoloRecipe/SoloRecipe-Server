package com.sr.solorecipe.global.security.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.sr.solorecipe.global.error.ErrorCode
import com.sr.solorecipe.global.error.ErrorResponse
import com.sr.solorecipe.global.error.exception.BasicException
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExceptionHandlerFilter(
    private val objectMapper: ObjectMapper
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
           try {
               filterChain.doFilter(request, response)
           } catch (e: BasicException) {
                sendError(e.errorCode, response)
           } catch (e: Exception) {
               response.characterEncoding = "UTF-8"
               sendError(ErrorCode.INTERNAL_SERVER_ERROR, response)
           }
    }

    private fun sendError(errorCode: ErrorCode, response: HttpServletResponse) {
        val errorResponse = ErrorResponse(errorCode.status, errorCode.message)
        val errorResponseEntityToJson = objectMapper.writeValueAsString(errorResponse)
        response.status = errorCode.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(errorResponseEntityToJson)
    }
}

