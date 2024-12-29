package com.ukyoda.book.api.config

import com.ukyoda.book.common.domain.auth.component.AllowH2Console
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
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
                    .requestMatchers(apiPath("/version"))
                    .permitAll()
                    .anyRequest()
                    .authenticated()
            }
        return http.build()
    }

    fun apiPath(path: String): String = "$apiPrefix$path"
}
