package com.ukyoda.book.common.infrastructure.users

import com.ukyoda.book.common.domain.users.model.User
import com.ukyoda.book.common.domain.users.repository.UserRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val userMapper: UserMapper,
) : UserRepository {
    override fun findByEmail(email: String) = userMapper.findByEmail(email)

    override fun findAll(page: Pageable) = userMapper.findAll(page.pageSize.toLong(), page.offset)

    override fun create(user: User): User {
        val id = userMapper.create(user)
        user.id = id
        return user
    }
}
