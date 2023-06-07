package com.sr.solorecipe.global.security.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.sr.solorecipe.domain.user.exception.UserNotFoundException
import com.sr.solorecipe.global.error.ErrorCode
import com.sr.solorecipe.global.error.ErrorResponse
import com.sr.solorecipe.global.error.exception.BasicException
import io.jsonwebtoken.ExpiredJwtException
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
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
           } catch (e: UserNotFoundException) {
                sendError(e.errorCode, response)
           } catch (e: ExpiredJwtException) {
               sendError(ErrorCode.EXPIRED_TOKEN, response)
           }
    }

    private fun sendError(errorCode: ErrorCode, response: HttpServletResponse) {
        response.status = errorCode.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        val errorResponse = ErrorResponse(errorCode.status, errorCode.message)
        val errorResponseEntityToJson = objectMapper.writeValueAsString(errorResponse)
        response.writer.write(errorResponseEntityToJson)
    }
}

