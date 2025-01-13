package com.ukyoda.book.usecase.books.service

import com.ukyoda.book.common.domain.books.model.Book
import com.ukyoda.book.common.domain.books.repository.BookRepository
import com.ukyoda.book.usecase.books.model.BookList
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class RetrieveBooks(
    val bookRepository: BookRepository,
) {
    val pageSize = 100

    fun find(page: Int): BookList {
        val pageable = Pageable.ofSize(pageSize).withPage(page - 1)
        val total = bookRepository.getTotal()
        val books = bookRepository.findAll(pageable)
        return BookList(books, total, page)
    }

    fun findById(id: Long): Book = bookRepository.findById(id)
}
