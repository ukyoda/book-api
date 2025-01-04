package com.ukyoda.book.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class VersionController {
    @GetMapping("/version")
    fun version(): Map<String, String> = mapOf("version" to "1.0.0")
}
