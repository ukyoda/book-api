package com.ukyoda.book.controller

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class AuthController(
    private val passwordEncoder: PasswordEncoder,
) {
    @GetMapping("/login")
    fun login(): String = "auth/login"

    @GetMapping("/auth/hash")
    fun hash(
        @RequestParam("str") str: String,
        model: Model,
    ): String {
        val encodedText = passwordEncoder.encode(str)
        model.addAttribute("encodedText", encodedText)
        return "auth/hash"
    }
}
