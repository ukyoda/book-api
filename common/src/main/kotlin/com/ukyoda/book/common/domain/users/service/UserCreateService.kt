package com.ukyoda.book.common.domain.users.service

import com.ukyoda.book.common.domain.users.model.User
import com.ukyoda.book.common.domain.users.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserCreateService(
    private val userRepository: UserRepository,
) {
    fun create(user: User) {
        userRepository.create(user)
    }
}
