package com.ukyoda.book.controller.auth.dto

import com.ukyoda.book.domain.user.model.RoleType
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class UserCreateDto(
    @NotEmpty(message = "メールアドレスを入力してください")
    @Email(message = "メールアドレスを入力してください")
    val email: String,
    @NotEmpty(message = "パスワードを入力してください")
    val password: String,
    @NotEmpty(message = "名前を入力してください")
    @Size(min = 1, max = 100, message = "名前は1文字以上100文字以下で入力してください")
    val name: String,
    @NotEmpty(message = "権限を入力してください")
    val roleType: RoleType,
)
