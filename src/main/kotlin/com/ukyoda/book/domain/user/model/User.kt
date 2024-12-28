package com.ukyoda.book.domain.user.model

data class User(
    var id: Long?,
    val email: String,
    val password: String,
    val name: String,
    val roleType: RoleType,
)
