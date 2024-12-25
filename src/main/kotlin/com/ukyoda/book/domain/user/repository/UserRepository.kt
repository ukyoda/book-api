package com.ukyoda.book.domain.user.repository

import com.ukyoda.book.domain.user.model.User
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable
import org.springframework.stereotype.Repository

@Repository
interface UserRepository {
    fun login(
        username: String,
        password: String,
    ): User

    fun findAll(pageable: Pageable): List<User>
}
