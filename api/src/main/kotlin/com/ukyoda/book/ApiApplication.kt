package com.ukyoda.book

import io.github.cdimascio.dotenv.Dotenv
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.function.Consumer

@SpringBootApplication
class ApiApplication

fun main(args: Array<String>) {
    val dotenv = Dotenv.load()
    dotenv.entries().forEach(
        Consumer { entry ->
            System.setProperty(entry.key, entry.value)
        },
    )
    runApplication<ApiApplication>(*args)
}
