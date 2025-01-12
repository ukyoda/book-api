package com.ukyoda.book.api.controller

import com.ukyoda.book.usecase.auth.component.JwtComponent
import com.ukyoda.book.usecase.auth.model.UserForm
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
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
class LoginController(
    private val daoAuthenticationProvider: DaoAuthenticationProvider,
    private val jwtComponent: JwtComponent,
) {
    @PostMapping("/login")
    fun login(
        @RequestBody userForm: UserForm,
    ): ResponseEntity<String> {
        try {
            daoAuthenticationProvider.authenticate(
                UsernamePasswordAuthenticationToken(
                    userForm.email,
                    userForm.password,
                ),
            )
            val token = jwtComponent.encode(userForm.email)
            val headers = HttpHeaders()
            headers.add("x-auth-token", token)
            return ResponseEntity.status(HttpStatus.OK).headers(headers).build()
        } catch (e: AuthenticationException) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
        }
    }

    @GetMapping("/check")
    fun sessionCheck(): String = "{ \"status\": \"ok\" }"
}
