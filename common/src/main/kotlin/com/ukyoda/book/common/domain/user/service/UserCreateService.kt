package com.ukyoda.book.common.domain.user.service

import com.ukyoda.book.common.domain.user.model.User
import com.ukyoda.book.common.domain.user.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserCreateService(
    private val userRepository: UserRepository,
) {
    fun create(user: User) {
        userRepository.create(user)
    }
}
