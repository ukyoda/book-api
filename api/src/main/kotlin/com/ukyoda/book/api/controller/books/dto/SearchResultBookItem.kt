package com.ukyoda.book.api.controller.books.dto

import com.ukyoda.book.common.domain.books.model.Book

data class SearchResultBookItem(
    val title: String,
    val isbn: String? = null,
    val description: String? = null,
    val image: Image? = null,
    val publisher: String,
    val publishedDate: Long? = null,
    val authors: List<String> = emptyList(),
) {
    companion object {
        fun fromDomain(book: Book) =
            SearchResultBookItem(
                title = book.title,
                isbn = book.isbn,
                description = book.description,
                image = Image(small = book.smallImageUrl, medium = book.mediumImageUrl, large = book.largeImageUrl),
                publisher = book.publisher,
                publishedDate = book.publishedDate,
                authors = book.authors.map { author -> author.name },
            )
    }

    data class Image(
        val small: String? = null,
        val medium: String? = null,
        val large: String? = null,
    )
}
