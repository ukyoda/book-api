package com.ukyoda.book.admin.controller.auth.dto

import com.ukyoda.book.admin.domain.user.model.RoleType
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class UserCreateDto(
    @NotEmpty(message = "メールアドレスを入力してください")
    @Email(message = "メールアドレスを入力してください")
    var email: String? = null,
    @NotEmpty(message = "パスワードを入力してください")
    var password: String? = null,
    @NotEmpty(message = "名前を入力してください")
    @Size(min = 1, max = 100, message = "名前は1文字以上100文字以下で入力してください")
    var name: String? = null,
    @NotEmpty(message = "権限を入力してください")
    var role: com.ukyoda.book.admin.domain.user.model.RoleType = com.ukyoda.book.admin.domain.user.model.RoleType.USER,
)
