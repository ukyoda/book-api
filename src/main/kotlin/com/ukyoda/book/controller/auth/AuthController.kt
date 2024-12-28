package com.ukyoda.book.controller.auth

import com.ukyoda.book.controller.auth.dto.UserCreateDto
import com.ukyoda.book.domain.user.model.RoleType
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class AuthController(
    private val passwordEncoder: PasswordEncoder,
) {
    @GetMapping("/login")
    fun login(): String = "auth/login"

    /**
     * テキストをハッシュ化するツール
     */
    @GetMapping("/auth/hash")
    fun hash(
        @RequestParam("str") str: String,
        model: Model,
    ): String {
        val encodedText = passwordEncoder.encode(str)
        model.addAttribute("encodedText", encodedText)
        return "auth/hash"
    }

    @GetMapping("/auth/users")
    fun users(): String = "auth/users"

    @GetMapping("/auth/users/create")
    fun userCreate(model: Model): String {
        model.addAttribute("roles", RoleType.values())
        return "auth/user_create"
    }

    @PostMapping("/auth/users/create")
    fun userCreate(
        @Validated @ModelAttribute form: UserCreateDto,
        bindingResult: BindingResult,
    ): String {
        if (bindingResult.hasErrors()) {
            return "auth/user_create"
        }
        return "redirect:/auth/users"
    }
}
