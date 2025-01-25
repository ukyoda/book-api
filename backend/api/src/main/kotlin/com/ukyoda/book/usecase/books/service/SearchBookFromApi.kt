package com.ukyoda.book.usecase.books.service

import com.ukyoda.book.common.domain.books.model.Book
import com.ukyoda.book.common.domain.books.repository.BookApiRepository
import com.ukyoda.book.common.domain.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class SearchBookFromApi(
    private val bookApiRepository: BookApiRepository,
) {
    fun searchByTitle(title: String): List<Book> = bookApiRepository.findByTitle(title)

    fun searchByAuthor(author: String): List<Book> = bookApiRepository.findByAuthor(author)

    fun searchByIsbn(isbn: String): Book = bookApiRepository.findByIsbn(isbn) ?: throw NotFoundException("books is not found")
}
