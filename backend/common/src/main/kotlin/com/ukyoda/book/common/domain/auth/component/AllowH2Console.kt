package com.ukyoda.book.common.domain.auth.component

import org.springframework.core.env.Environment
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.stereotype.Component

@Component
class AllowH2Console(
    private val env: Environment,
) {
    fun allow(http: HttpSecurity) {
        if (env.acceptsProfiles { it.test("local") }) {
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
        }
    }
}
