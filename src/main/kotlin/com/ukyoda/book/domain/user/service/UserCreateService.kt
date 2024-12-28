package com.ukyoda.book.domain.user.service

import com.ukyoda.book.domain.user.model.User
import com.ukyoda.book.domain.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserCreateService(
    private val userRepository: UserRepository,
) {
    fun create(user: User) {
        userRepository.create(user)
    }
}
