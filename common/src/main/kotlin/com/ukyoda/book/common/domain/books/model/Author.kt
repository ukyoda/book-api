package com.ukyoda.book.common.domain.books.model

data class Author(
    val name: String,
) {
    companion object {
        fun from(author: Author) =
            Author(
                name = author.name,
            )
    }
}
