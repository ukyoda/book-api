package com.ukyoda.book.common.domain.books.model

data class Book(
    val id: Long? = null,
    val name: String,
    val description: String,
    val smallImageUrl: String?,
    val mediumImageUrl: String?,
    val largeImageUrl: String?,
    val publisher: String,
    val publishedDate: Long?,
    val authors: List<Author> = emptyList(),
) {
    companion object {
        fun from(book: Book) =
            Book(
                id = book.id,
                name = book.name,
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
            name = book.name,
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
