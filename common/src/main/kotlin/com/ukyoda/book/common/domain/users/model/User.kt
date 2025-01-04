package com.ukyoda.book.common.domain.users.model

data class User(
    var id: Long? = null,
    val email: String,
    val password: String,
    val name: String,
    val roleType: RoleType,
)
