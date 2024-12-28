package com.ukyoda.book.config

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity

// @EnableGlobalMethodSecurityを使うとPreAuthorizeを有効にする
@EnableMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig
