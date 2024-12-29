package com.ukyoda.book.common.domain.user.model

data class User(
    var id: Long? = null,
    val email: String,
    val password: String,
    val name: String,
    val roleType: RoleType,
)
