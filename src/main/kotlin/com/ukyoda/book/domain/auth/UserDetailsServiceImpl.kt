package com.ukyoda.book.domain.auth

import com.ukyoda.book.domain.user.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(
    private val userRepository: UserRepository,
) : UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails {
        val user =
            userRepository.findByEmail(email) ?: throw UsernameNotFoundException("User not found")

        return User
            .withUsername(user.email)
            .password(user.password)
            .roles(user.roleType.name)
            .build() ?: throw UsernameNotFoundException("User not found")
    }
}
