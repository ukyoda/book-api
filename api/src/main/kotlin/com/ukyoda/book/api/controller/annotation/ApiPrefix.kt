package com.ukyoda.book.api.controller.annotation

import org.springframework.web.bind.annotation.RequestMapping

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@RequestMapping("\${api.prefix}")
annotation class ApiPrefix
