package com.ukyoda.book.common.domain.books.repository

import com.ukyoda.book.common.domain.books.model.Book
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
interface BookRepository {
    fun findById(id: Long): Book

    fun getTotal(): Int

    fun findByTitle(title: String): List<Book>

    fun findAll(page: Pageable): List<Book>
}
