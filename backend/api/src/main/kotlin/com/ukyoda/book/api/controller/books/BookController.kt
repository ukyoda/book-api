package com.ukyoda.book.api.controller.books

import com.ukyoda.book.api.controller.books.dto.BookListResponseData
import com.ukyoda.book.api.controller.books.dto.BookRequestData
import com.ukyoda.book.api.controller.books.dto.BookResponseData
import com.ukyoda.book.api.controller.dto.ErrorResponse
import com.ukyoda.book.common.domain.exception.NotFoundException
import com.ukyoda.book.usecase.books.service.BookRegister
import com.ukyoda.book.usecase.books.service.RetrieveBooks
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/books")
class BookController(
    val bookRegister: BookRegister,
    val retrieveBooks: RetrieveBooks,
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

    @GetMapping
    fun find(
        @RequestParam page: Int = 1,
    ): ResponseEntity<BookListResponseData> =
        ResponseEntity
            .ok(
                BookListResponseData.fromBookList(retrieveBooks.find(page)),
            )

    @GetMapping("/{id}")
    fun find(
        @PathVariable("id") id: Long,
    ): ResponseEntity<Any> =
        try {
            ResponseEntity.ok(
                BookResponseData.fromDomain(
                    retrieveBooks.findById(id),
                ),
            )
        } catch (e: NotFoundException) {
            ResponseEntity.status(404).body(
                ErrorResponse(
                    code = 404,
                    reason = "NOT_FOUND",
                    message = "NotFound",
                ),
            )
        }
}
