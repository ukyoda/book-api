package com.ukyoda.book.infrastructure.users

import com.ukyoda.book.domain.user.model.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable

@Mapper
interface UserMapper {
    @Select(
        """
        SELECT
            *
        FROM
            users
        WHERE
            username = #{userName}
            AND password = #{password}
        """,
    )
    fun login(
        userName: String,
        password: String,
    ): User

    @Select(
        """
        SELECT
            *
        FROM
            users
        LIMIT
            #{pageable.offset} #{pageable.pageSize}
        ORDER BY
            id DESC
        """,
    )
    fun findAll(pageable: Pageable): List<User>
}
