package com.ukyoda.book.controller.users.dto

import com.ukyoda.book.domain.user.model.RoleType
import com.ukyoda.book.domain.user.model.User

data class UserResponse(
    val id: Long,
    val email: String,
    val name: String,
    val roleType: RoleType,
) {
    companion object {
        fun from(user: User): UserResponse =
            user.id?.let {
                UserResponse(
                    id = it,
                    email = user.email,
                    name = user.name,
                    roleType = user.roleType,
                )
            } ?: throw IllegalArgumentException("User id is null")
    }
}
