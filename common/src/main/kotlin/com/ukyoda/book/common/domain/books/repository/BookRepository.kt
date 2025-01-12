package com.ukyoda.book.common.domain.books.repository

import com.ukyoda.book.common.domain.books.model.Book
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
interface BookRepository {
    fun create(book: Book): Long

    fun findById(id: Long): Book

    fun getTotal(): Int

    fun findAll(page: Pageable): List<Book>
}
