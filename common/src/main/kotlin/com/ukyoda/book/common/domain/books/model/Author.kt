package com.ukyoda.book.common.domain.books.model

data class Author(
    val id: Long? = null,
    val name: String,
) {
    companion object {
        fun from(author: Author) =
            Author(
                id = author.id,
                name = author.name,
            )

        fun from(
            id: Long,
            author: Author,
        ) = Author(
            id,
            name = author.name,
        )
    }
}
