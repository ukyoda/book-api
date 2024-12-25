package com.ukyoda.book.controller.users

import com.ukyoda.book.domain.user.model.User
import com.ukyoda.book.domain.user.repository.UserRepository
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users")
class UsersController(
    private val userRepository: UserRepository,
) {
    @GetMapping("/")
    fun index(
        @RequestParam("page") page: Int = 0,
    ): List<User> {
        val page: Pageable = Pageable.ofSize(100).withPage(page)
        return userRepository.findAll(page)
    }
}
