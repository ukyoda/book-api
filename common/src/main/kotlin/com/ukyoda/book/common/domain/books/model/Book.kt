package com.ukyoda.book.common.domain.books.model

data class Book(
    val id: Long? = null,
    val title: String,
    val isbn: String? = null,
    val description: String,
    val smallImageUrl: String? = null,
    val mediumImageUrl: String? = null,
    val largeImageUrl: String? = null,
    val publisher: String,
    val publishedDate: Long? = null,
    val authors: List<Author> = emptyList(),
) {
    companion object {
        fun from(book: Book) =
            Book(
                id = book.id,
                title = book.title,
                isbn = book.isbn,
                description = book.description,
                smallImageUrl = book.smallImageUrl,
                mediumImageUrl = book.mediumImageUrl,
                largeImageUrl = book.largeImageUrl,
                publisher = book.publisher,
                publishedDate = book.publishedDate,
                authors = book.authors,
            )

        fun from(
            id: Long,
            book: Book,
        ) = Book(
            id = id,
            title = book.title,
            isbn = book.isbn,
            description = book.description,
            smallImageUrl = book.smallImageUrl,
            mediumImageUrl = book.mediumImageUrl,
            largeImageUrl = book.largeImageUrl,
            publisher = book.publisher,
            publishedDate = book.publishedDate,
            authors = book.authors,
        )
    }
}
