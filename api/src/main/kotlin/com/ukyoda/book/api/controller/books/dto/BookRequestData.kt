package com.ukyoda.book.api.controller.books.dto

import com.ukyoda.book.common.domain.books.model.Author
import com.ukyoda.book.common.domain.books.model.Book
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class BookRequestData(
    @Size(min = 1, max = 128)
    val title: String,
    @Pattern(regexp = "^[0-9]+$")
    val isbn: String? = null,
    @Size(min = 1, max = 1024)
    val description: String? = null,
    val image: BookImage? = null,
    @Size(min = 1, max = 128)
    val publisher: String,
    @Size(min = 1, max = 128)
    val publishedDate: Long? = null,
    val authors: List<String> = emptyList(),
) {
    fun toDomain(): Book =
        Book(
            title = title,
            isbn = isbn,
            description = description,
            smallImageUrl = image?.small,
            mediumImageUrl = image?.medium,
            largeImageUrl = image?.large,
            publisher = publisher,
            publishedDate = publishedDate,
            authors =
                authors.map { authorName ->
                    Author(name = authorName)
                },
        )
}
