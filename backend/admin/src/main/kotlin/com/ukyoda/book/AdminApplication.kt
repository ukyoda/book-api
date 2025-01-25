package com.ukyoda.book

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.ukyoda.book.admin", "com.ukyoda.book.common"])
class AdminApplication

fun main(args: Array<String>) {
    runApplication<com.ukyoda.book.AdminApplication>(*args)
}
