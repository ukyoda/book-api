package com.ukyoda.book.domain.auth.component

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.Date
import java.util.UUID

@Component
class JwtComponent(
    @Value("\${api.secret}") private val apiSecret: String,
) {
    private val expirationTime: Long = 1000L * 3600L * 24L

    fun decode(token: String) =
        JWT
            .require(Algorithm.HMAC256(apiSecret))
            .withIssuer("ukyoda")
            .withSubject("books-api")
            .build()
            .verify(token)

    fun encode(email: String): String {
        val current = Date()
        val notBefore = Date(current.time)
        val expiresAt = Date(current.time + expirationTime)
        return JWT
            .create()
            .withIssuer("ukyoda")
            .withSubject("books-api")
            .withIssuedAt(current)
            .withNotBefore(notBefore)
            .withExpiresAt(expiresAt)
            .withJWTId(UUID.randomUUID().toString())
            .withClaim("email", email)
            .sign(Algorithm.HMAC256(apiSecret))
    }
}
