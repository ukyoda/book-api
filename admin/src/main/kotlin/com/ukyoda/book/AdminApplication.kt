package com.ukyoda.book

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AdminApplication

fun main(args: Array<String>) {
    runApplication<com.ukyoda.book.AdminApplication>(*args)
}
