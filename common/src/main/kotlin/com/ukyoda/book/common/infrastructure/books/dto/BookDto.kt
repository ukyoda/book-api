package com.ukyoda.book.common.infrastructure.books.dto

import com.ukyoda.book.common.domain.books.model.Book

data class BookDto(
    val id: Long? = null,
    val title: String,
    val isbn: String? = null,
    val description: String? = null,
    val smallImageUrl: String? = null,
    val mediumImageUrl: String? = null,
    val largeImageUrl: String? = null,
    val publisher: String,
    val publishedDate: Long? = null,
) {
    companion object {
        fun fromDomain(book: Book) =
            BookDto(
                id = book.id,
                title = book.title,
                isbn = book.isbn,
                description = book.description,
                smallImageUrl = book.smallImageUrl,
                mediumImageUrl = book.mediumImageUrl,
                largeImageUrl = book.largeImageUrl,
                publisher = book.publisher,
                publishedDate = book.publishedDate,
            )
    }
}
