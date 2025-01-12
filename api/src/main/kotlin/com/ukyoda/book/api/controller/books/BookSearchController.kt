package com.ukyoda.book.api.controller.books

import com.fasterxml.jackson.databind.ObjectMapper
import com.ukyoda.book.api.controller.books.dto.SearchResultBookItem
import com.ukyoda.book.api.controller.dto.ErrorResponse
import com.ukyoda.book.common.domain.exception.NotFoundException
import com.ukyoda.book.usecase.books.service.SearchBookFromApi
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
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
    ): String =
        ObjectMapper()
            .writerWithDefaultPrettyPrinter()
            .writeValueAsString(
                searchBookFromApi.searchByTitle(title).map { book ->
                    SearchResultBookItem.fromDomain(book)
                },
            )

    @GetMapping("/author")
    fun searchByAuthor(
        @RequestParam("q")
        @NotBlank
        author: String,
    ) = ObjectMapper()
        .writerWithDefaultPrettyPrinter()
        .writeValueAsString(
            searchBookFromApi
                .searchByAuthor(author)
                .map { book ->
                    SearchResultBookItem.fromDomain(book)
                },
        )

    @GetMapping("/isbn")
    fun searchByIsbn(
        @RequestParam("q")
        @NotBlank
        @Pattern(regexp = "^[0-9]+$")
        isbn: String,
    ): String? {
        try {
            return ObjectMapper()
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(
                    searchBookFromApi
                        .searchByIsbn(isbn)
                        .let { book ->
                            SearchResultBookItem.fromDomain(book)
                        },
                )
        } catch (e: NotFoundException) {
            return ObjectMapper()
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(
                    ErrorResponse(
                        code = 404,
                        reason = "BOOK_NOT_FOUND",
                        message = "Books are not found",
                    ),
                )
        }
    }
}
