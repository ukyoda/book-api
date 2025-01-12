package com.ukyoda.book.api.controller.books

import com.ukyoda.book.api.controller.books.dto.BookRequestData
import com.ukyoda.book.api.controller.dto.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/books")
class BookController {
    @PostMapping
    fun create(
        @RequestBody @Validated bookRequestNewData: BookRequestData,
        bindingResult: BindingResult,
    ): ResponseEntity<Any> {
        if (bindingResult.hasErrors()) {
            return ResponseEntity
                .status(400)
                .body(
                    ErrorResponse(code = 400, reason = "INVALID_INPUT", message = "Bad Request"),
                )
        }

        return ResponseEntity.ok(mapOf("a" to 1, "b" to 2))
    }
}
