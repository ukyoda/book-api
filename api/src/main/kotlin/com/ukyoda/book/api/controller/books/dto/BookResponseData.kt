package com.ukyoda.book.api.controller.books.dto

data class BookResponseData(
    val id: Long,
    val title: String,
    val isbn: String? = null,
    val description: String? = null,
    val image: BookImage,
    val publisher: String,
    val publishedDate: Long? = null,
    val authors: List<String> = emptyList(),
) {
    companion object {
        fun fromDomain(book: com.ukyoda.book.common.domain.books.model.Book): BookResponseData =
            BookResponseData(
                id = book.id!!,
                title = book.title,
                isbn = book.isbn,
                description = book.isbn,
                image =
                    BookImage(
                        small = book.smallImageUrl,
                        medium = book.mediumImageUrl,
                        large = book.largeImageUrl,
                    ),
                publisher = book.publisher,
                publishedDate = book.publishedDate,
                authors =
                    book.authors.map {
                        it.name
                    },
            )
    }
}
