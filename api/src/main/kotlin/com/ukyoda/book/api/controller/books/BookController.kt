package com.ukyoda.book.api.controller.books

import com.ukyoda.book.api.controller.books.dto.BookRequestData
import com.ukyoda.book.api.controller.dto.ErrorResponse
import com.ukyoda.book.usecase.books.service.BookRegister
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/books")
class BookController(
    val bookRegister: BookRegister,
) {
    @PostMapping
    fun create(
        @RequestBody @Validated bookRequestData: BookRequestData,
        bindingResult: BindingResult,
    ): ResponseEntity<Any> {
        if (bindingResult.hasErrors()) {
            return ResponseEntity
                .status(400)
                .body(
                    ErrorResponse(code = 400, reason = "INVALID_INPUT", message = "Bad Request"),
                )
        }
        try {
            val book = bookRegister.regist(bookRequestData.toDomain())
            return ResponseEntity.ok(book)
        } catch (e: Exception) {
            e.printStackTrace()
            return ResponseEntity
                .status(500)
                .body(
                    ErrorResponse(
                        code = 500,
                        reason = "INTERNAL_ERROR",
                        message = "登録できませんでした",
                    ),
                )
        }
    }
}
