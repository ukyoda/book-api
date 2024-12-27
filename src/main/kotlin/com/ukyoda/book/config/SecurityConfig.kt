package com.ukyoda.book.config

import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        // h2-consoleの設定
        http
            .authorizeHttpRequests { authz ->
                authz
                    .requestMatchers("/h2-console/**")
                    .permitAll()
            }.csrf { csrf ->
                csrf
                    .ignoringRequestMatchers("/h2-console/**")
            }.headers { header ->
                header
                    .frameOptions { frameOption ->
                        frameOption.disable()
                    }
            }

        http
            .formLogin { login ->
                login
                    .loginPage("/login")
                    .permitAll()
                    .successForwardUrl("/my")
                    .failureUrl("/login?error")
            }.authorizeHttpRequests { authz ->
                authz
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                    .permitAll()
                    .requestMatchers("/hello/**", "/")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
            }
        return http.build()
    }
}
