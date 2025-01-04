package com.ukyoda.book.common.domain.auth.component

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder

fun getPasswordEncoder(): PasswordEncoder {
    val pbkdf2PasswordEncoder =
        Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8()
    pbkdf2PasswordEncoder.setEncodeHashAsBase64(true)
    return pbkdf2PasswordEncoder
}