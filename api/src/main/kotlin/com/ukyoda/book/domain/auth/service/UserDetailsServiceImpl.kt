package com.ukyoda.book.domain.auth.service

import com.ukyoda.book.common.domain.users.repository.UserRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(
    private val repository: UserRepository,
) : UserDetailsService {
    override fun loadUserByUsername(email: String?): UserDetails {
        val user =
            email?.let {
                repository.findByEmail(it)
            } ?: throw UsernameNotFoundException("User not found")
        return User
            .withUsername(user.email)
            .password(user.password)
            .roles(user.roleType.name)
            .build() ?: throw UsernameNotFoundException("User not found")
    }
}
