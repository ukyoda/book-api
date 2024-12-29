package com.ukyoda.book.admin.domain.user.repository

import com.ukyoda.book.admin.domain.user.model.User
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
interface UserRepository {
    fun findByEmail(email: String): com.ukyoda.book.admin.domain.user.model.User?

    fun findAll(page: Pageable): List<com.ukyoda.book.admin.domain.user.model.User>

    fun create(user: com.ukyoda.book.admin.domain.user.model.User): com.ukyoda.book.admin.domain.user.model.User
}
