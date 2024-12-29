package com.ukyoda.book.common.domain.user.repository

import com.ukyoda.book.common.domain.user.model.User
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
interface UserRepository {
    fun findByEmail(email: String): User?

    fun findAll(page: Pageable): List<User>

    fun create(user: User): User
}
