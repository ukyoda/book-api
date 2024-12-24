package com.ukyoda.book.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("hello")
class HelloController {
    @GetMapping("/")
    fun hello(model: Model): String {
        model.addAttribute("message", "Hello world!")
        return "hello/index"
    }
}
