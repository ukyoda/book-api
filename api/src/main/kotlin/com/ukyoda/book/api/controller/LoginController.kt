package com.ukyoda.book.api.controller

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.ukyoda.book.api.controller.annotation.ApiPrefix
import com.ukyoda.book.domain.auth.component.JwtComponent
import com.ukyoda.book.domain.auth.model.UserForm
import org.apache.coyote.Response
import org.apache.tomcat.websocket.AuthenticationException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@ApiPrefix
@CrossOrigin
class LoginController(
    private val daoAuthenticationProvider: DaoAuthenticationProvider,
    private val jwtComponent: JwtComponent
) {
    @PostMapping("/login")
    fun login(@RequestBody userForm: UserForm): ResponseEntity<String> {
        try {
            daoAuthenticationProvider.authenticate(
                UsernamePasswordAuthenticationToken(
                    userForm.username,
                    userForm.password
                )
            )
            val token = jwtComponent.encode(userForm.username)
            val headers = HttpHeaders()
            headers.add("x-auth-token", token)
            return ResponseEntity.status(HttpStatus.OK).headers(headers).build()
        } catch (e: AuthenticationException) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }

    @GetMapping("/check")
    fun sessionCheck(): String {
        return "{ \"status\": \"ok\" }"
    }
}