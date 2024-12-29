package com.ukyoda.book.api.controller

import com.ukyoda.book.api.controller.annotation.ApiPrefix
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@ApiPrefix
class VersionController {
    @GetMapping("/version")
    fun version(): Map<String, String> = mapOf("version" to "1.0.0")
}
