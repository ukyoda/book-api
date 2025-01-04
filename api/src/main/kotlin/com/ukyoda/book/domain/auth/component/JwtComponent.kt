package com.ukyoda.book.domain.auth.component

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class JwtComponent(
    @Value("\${api.secret}") private val apiSecret: String
) {
    fun decode(token: String) = JWT
        .require(Algorithm.HMAC256(apiSecret))
        .build()
        .verify(token)

    fun encode(email: String) = JWT
        .create()
        .withClaim("username", email)
        .sign(Algorithm.HMAC256(apiSecret))
}