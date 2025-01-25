package com.ukyoda.book.common.domain.books.repository

import com.ukyoda.book.common.domain.books.model.Book
import org.springframework.stereotype.Repository

@Repository
interface BookApiRepository {
    fun findByTitle(title: String): List<Book>

    fun findByIsbn(isbn: String): Book?

    fun findByAuthor(author: String): List<Book>
}
