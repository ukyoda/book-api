package com.ukyoda.book.api.controller.books

import com.ukyoda.book.api.controller.books.dto.BookSearchResponseData
import com.ukyoda.book.api.controller.dto.ErrorResponse
import com.ukyoda.book.common.domain.exception.NotFoundException
import com.ukyoda.book.usecase.books.service.SearchBookFromApi
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/books/search")
class BookSearchController(
    val searchBookFromApi: SearchBookFromApi,
) {
    @GetMapping("/title")
    fun searchByTitle(
        @RequestParam("q")
        @NotBlank
        title: String,
    ) = ResponseEntity.ok(
        searchBookFromApi.searchByTitle(title).map { book ->
            BookSearchResponseData.fromDomain(book)
        },
    )

    @GetMapping("/author")
    fun searchByAuthor(
        @RequestParam("q")
        @NotBlank
        author: String,
    ) = ResponseEntity.ok(
        searchBookFromApi
            .searchByAuthor(author)
            .map { book ->
                BookSearchResponseData.fromDomain(book)
            },
    )

    @GetMapping("/isbn")
    fun searchByIsbn(
        @RequestParam("q")
        @NotBlank
        @Pattern(regexp = "^[0-9]+$")
        isbn: String,
    ): ResponseEntity<Any> {
        try {
            return ResponseEntity.ok(
                searchBookFromApi
                    .searchByIsbn(isbn)
                    .let { book ->
                        BookSearchResponseData.fromDomain(book)
                    },
            )
        } catch (e: NotFoundException) {
            return ResponseEntity.status(404).body(
                ErrorResponse(
                    code = 404,
                    reason = "BOOK_NOT_FOUND",
                    message = "Books are not found",
                ),
            )
        }
    }
}
