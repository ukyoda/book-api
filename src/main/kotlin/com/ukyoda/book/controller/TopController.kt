package com.ukyoda.book.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TopController {
    @GetMapping("/")
    fun top(): String = "{ \"message\": \"Hello, world!\" }"
}
