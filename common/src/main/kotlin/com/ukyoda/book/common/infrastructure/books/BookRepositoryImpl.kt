package com.ukyoda.book.common.infrastructure.books

import com.ukyoda.book.common.domain.books.model.Book
import com.ukyoda.book.common.domain.books.repository.BookRepository
import com.ukyoda.book.common.infrastructure.books.BookMapper
import com.ukyoda.book.common.infrastructure.books.dto.BookDto
import org.springframework.data.domain.Pageable
import java.time.Clock

class BookRepositoryImpl(
    val bookMapper: BookMapper,
) : BookRepository {
    override fun create(book: Book): Long {
        val clock = Clock.systemUTC().instant()
        val createdAt = clock.epochSecond
        val updatedAt = createdAt
        return bookMapper.insert(
            BookDto.fromDomain(book),
            createdAt,
            updatedAt,
        )
    }

    override fun findById(id: Long): Book {
        TODO("Not yet implemented")
    }

    override fun getTotal(): Int {
        TODO("Not yet implemented")
    }

    override fun findAll(page: Pageable): List<Book> {
        TODO("Not yet implemented")
    }
}
