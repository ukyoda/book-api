package com.ukyoda.book.admin.controller.auth

import com.ukyoda.book.common.domain.users.model.RoleType
import com.ukyoda.book.common.domain.users.model.User
import com.ukyoda.book.common.domain.users.service.UserCreateService
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
    private val userCreateService: UserCreateService,
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
    fun showUserCreate(
        @ModelAttribute("form") form: com.ukyoda.book.admin.controller.auth.dto.UserCreateDto,
        model: Model,
    ): String {
        model.addAttribute(
            "roles",
            RoleType
                .values(),
        )
        return "auth/user_create"
    }

    @PostMapping("/auth/users/create")
    fun userCreate(
        @Validated @ModelAttribute("form") form: com.ukyoda.book.admin.controller.auth.dto.UserCreateDto,
        model: Model,
        bindingResult: BindingResult,
    ): String {
        if (bindingResult.hasErrors()) {
            return showUserCreate(form, model)
        }
        val user: User =
            User(
                id = null,
                email = form.email!!,
                password = passwordEncoder.encode(form.password!!),
                name = form.name!!,
                roleType = form.role,
            )
        userCreateService.create(user)
        return "redirect:/auth/users"
    }
}
