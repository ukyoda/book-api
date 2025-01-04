package com.ukyoda.book.api.config

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.ukyoda.book.common.domain.auth.component.AllowH2Console
import com.ukyoda.book.common.domain.auth.component.getPasswordEncoder
import com.ukyoda.book.domain.auth.component.JwtAuthorizeFilter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val authorizeFilter: JwtAuthorizeFilter,
    private val allowH2Console: AllowH2Console,
    @Value("\${api.prefix}") private val apiPrefix: String,
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        allowH2Console.allow(http)
        http
            .csrf { csrf -> csrf.disable() }
            .authorizeHttpRequests { authz ->
                authz
                    .requestMatchers(
                        apiPath("/version"),
                        apiPath("/login"),
                    ).permitAll()
                    .anyRequest()
                    .authenticated()
            }
            .addFilterBefore(authorizeFilter, UsernamePasswordAuthenticationFilter::class.java)
        return http.build()
    }

    @Bean
    fun authenticationProvider(userDetailsService: UserDetailsService): DaoAuthenticationProvider {
        val provider = DaoAuthenticationProvider()
        provider.setUserDetailsService(userDetailsService)
        provider.setPasswordEncoder(passwordEncoder())
        return provider
    }

    @Bean
    fun passwordEncoder() = getPasswordEncoder()

    private fun apiPath(path: String): String = "$apiPrefix$path"
}
