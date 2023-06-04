package com.sr.solorecipe.global.security.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.sr.solorecipe.global.security.CustomAuthenticationEntryPoint
import com.sr.solorecipe.global.security.filter.JwtAuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val objectMapper: ObjectMapper,
    private val jwtAuthenticationFilter: JwtAuthenticationFilter,
    private val exceptionFilter: JwtAuthenticationFilter
) {
    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain {
        return http
            .cors().disable()
            .csrf().disable()
            .formLogin().disable()
            .httpBasic().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()
            .authorizeRequests()

            .antMatchers(HttpMethod.POST,"/auth/register").permitAll()
            .antMatchers(HttpMethod.POST,"/auth/login").permitAll()
            .antMatchers(HttpMethod.PATCH,"/auth").permitAll()

            .antMatchers(HttpMethod.GET,"/recipe/suggest").authenticated()
            .antMatchers(HttpMethod.GET,"/recipe/all").authenticated()
                .antMatchers(HttpMethod.GET,"/recipe/search").authenticated()
            .antMatchers(HttpMethod.GET,"/recipe/detail/**").authenticated()
            .antMatchers(HttpMethod.PATCH,"/recipe/**").authenticated()

            .antMatchers(HttpMethod.GET,"/user").authenticated()

            .anyRequest().denyAll()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(CustomAuthenticationEntryPoint(objectMapper))

            .and()
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
            .addFilterBefore(exceptionFilter, UsernamePasswordAuthenticationFilter::class.java)
            .build()
    }
}