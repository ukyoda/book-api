package com.ukyoda.book.admin.config

import com.ukyoda.book.common.domain.auth.component.AllowH2Console
import com.ukyoda.book.common.domain.auth.component.getPasswordEncoder
import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val allowH2Console: AllowH2Console,
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        // h2-consoleの設定
        allowH2Console.allow(http)

        http
            .formLogin { login ->
                login
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/hello")
                    .failureUrl("/login?error")
            }.authorizeHttpRequests { authz ->
                authz
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                    .permitAll()
                    .requestMatchers("/", "/auth/hash")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
            }
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        // 平文のパスワード認証を使う場合（非推奨）
        // return NoOpPasswordEncoder.getInstance()

        // PBKDF2アルゴリズムによるパスワード暗号化定義
        return getPasswordEncoder()
    }
}
