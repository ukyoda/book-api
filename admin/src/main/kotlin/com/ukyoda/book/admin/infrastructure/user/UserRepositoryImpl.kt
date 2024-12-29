package com.ukyoda.book.admin.infrastructure.user

import com.ukyoda.book.admin.domain.user.model.User
import com.ukyoda.book.admin.domain.user.repository.UserRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val userMapper: com.ukyoda.book.admin.infrastructure.user.UserMapper,
) : com.ukyoda.book.admin.domain.user.repository.UserRepository {
    override fun findByEmail(email: String) = userMapper.findByEmail(email)

    override fun findAll(page: Pageable) = userMapper.findAll(page.pageSize.toLong(), page.offset)

    override fun create(user: com.ukyoda.book.admin.domain.user.model.User): com.ukyoda.book.admin.domain.user.model.User {
        val id = userMapper.create(user)
        user.id = id
        return user
    }
}
