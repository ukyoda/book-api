package com.ukyoda.book.infrastructure.users

import com.ukyoda.book.domain.user.repository.UserRepository
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val userMapper: UserMapper,
) : UserRepository {
    override fun login(
        username: String,
        password: String,
    ) = userMapper.login(username, password)

    override fun findAll(pageable: Pageable) = userMapper.findAll(pageable)
}
