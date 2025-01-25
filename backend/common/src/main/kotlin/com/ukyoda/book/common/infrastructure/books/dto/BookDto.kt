package com.ukyoda.book.common.infrastructure.books.dto

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.ukyoda.book.common.domain.books.model.Author
import com.ukyoda.book.common.domain.books.model.Book

data class BookDto(
    val id: Long? = null,
    val title: String,
    val isbn: String? = null,
    val description: String? = null,
    val smallImageUrl: String? = null,
    val mediumImageUrl: String? = null,
    val largeImageUrl: String? = null,
    val authors: String,
    val publisher: String,
    val publishedDate: Long? = null,
    val createdAt: Long? = null,
    val updatedAt: Long? = null,
) {
    companion object {
        fun fromDomain(
            book: Book,
            createdAt: Long? = null,
            updatedAt: Long? = null,
        ) = BookDto(
            id = book.id,
            title = book.title,
            isbn = book.isbn,
            description = book.description,
            smallImageUrl = book.smallImageUrl,
            mediumImageUrl = book.mediumImageUrl,
            largeImageUrl = book.largeImageUrl,
            authors =
                ObjectMapper()
                    .writeValueAsString(
                        book.authors.map { it.name },
                    ),
            publisher = book.publisher,
            publishedDate = book.publishedDate,
            createdAt = createdAt,
            updatedAt = updatedAt,
        )
    }

    fun toDomain(): Book {
        val typeReference = object : TypeReference<List<String>>() {}
        val unescapedAuthors =
            authors
                .trim('"')
                .replace("\\\"", "\"")
        return Book(
            id = id,
            title = title,
            isbn = isbn,
            description = description,
            smallImageUrl = smallImageUrl,
            mediumImageUrl = mediumImageUrl,
            largeImageUrl = largeImageUrl,
            authors =
                ObjectMapper()
                    .readValue(unescapedAuthors, typeReference)
                    .map { Author(name = it) },
            publisher = publisher,
            publishedDate = publishedDate,
        )
    }
}
