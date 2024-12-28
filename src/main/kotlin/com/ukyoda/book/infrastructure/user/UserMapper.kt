package com.ukyoda.book.infrastructure.user

import com.ukyoda.book.domain.user.model.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMapper {
    @Select(
        """
        SELECT
            *
        FROM
            users
        WHERE
            email = #{email}
        """,
    )
    fun findByEmail(email: String): User

    @Select(
        """
        SELECT
            id,
            email,
            name,
            role_type
        FROM
            users
        LIMIT
            #{offset}, #{limit}
        """,
    )
    fun findAll(
        limit: Long,
        offset: Long,
    ): List<User>

    @Insert(
        """
        INSERT INTO
            users
        (
            email,
            password,
            name,
            role_type
        )
        VALUES
        (
            #{email},
            #{password},
            #{name},
            #{roleType}
        )
        """,
    )
    fun create(user: User): Long
}
