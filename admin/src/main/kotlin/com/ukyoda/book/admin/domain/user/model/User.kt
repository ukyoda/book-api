package com.ukyoda.book.admin.domain.user.model

data class User(
    var id: Long? = null,
    val email: String,
    val password: String,
    val name: String,
    val roleType: com.ukyoda.book.admin.domain.user.model.RoleType,
)
