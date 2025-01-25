package com.ukyoda.book.api.controller.books.dto

import com.ukyoda.book.common.domain.books.model.Book

data class BookSearchResponseData(
    val title: String,
    val isbn: String? = null,
    val description: String? = null,
    val image: BookImage? = null,
    val publisher: String,
    val publishedDate: Long? = null,
    val authors: List<String> = emptyList(),
) {
    companion object {
        fun fromDomain(book: Book) =
            BookSearchResponseData(
                title = book.title,
                isbn = book.isbn,
                description = book.description,
                image =
                    BookImage(
                        small = book.smallImageUrl,
                        medium = book.mediumImageUrl,
                        large = book.largeImageUrl,
                    ),
                publisher = book.publisher,
                publishedDate = book.publishedDate,
                authors = book.authors.map { author -> author.name },
            )
    }
}
