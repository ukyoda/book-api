package com.ukyoda.book.admin.domain.user.service

import com.ukyoda.book.admin.domain.user.model.User
import com.ukyoda.book.admin.domain.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserCreateService(
    private val userRepository: com.ukyoda.book.admin.domain.user.repository.UserRepository,
) {
    fun create(user: com.ukyoda.book.admin.domain.user.model.User) {
        userRepository.create(user)
    }
}
