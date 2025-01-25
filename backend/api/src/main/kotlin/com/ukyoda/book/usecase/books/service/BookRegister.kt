package com.ukyoda.book.usecase.books.service

import com.ukyoda.book.common.domain.books.model.Book
import com.ukyoda.book.common.domain.books.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookRegister(
    val bookRepository: BookRepository,
) {
    fun regist(book: Book): Book = bookRepository.create(book)
}
