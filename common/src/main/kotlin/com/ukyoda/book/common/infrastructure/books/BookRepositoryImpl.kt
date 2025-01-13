package com.ukyoda.book.common.infrastructure.books

import com.ukyoda.book.common.domain.books.model.Book
import com.ukyoda.book.common.domain.books.repository.BookRepository
import com.ukyoda.book.common.domain.exception.NotFoundException
import com.ukyoda.book.common.infrastructure.books.BookMapper
import com.ukyoda.book.common.infrastructure.books.dto.BookDto
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import java.time.Clock

@Repository
class BookRepositoryImpl(
    val bookMapper: BookMapper,
) : BookRepository {
    override fun create(book: Book): Book {
        val clock = Clock.systemUTC().instant()
        val currentTime = clock.epochSecond
        val bookDto = BookDto.fromDomain(book)
        bookMapper.insert(
            bookDto,
            currentTime,
            currentTime,
        )
        return findById(bookDto.id!!)
    }

    override fun findById(id: Long): Book =
        bookMapper
            .findById(id)
            ?.toDomain()
            ?: throw NotFoundException("Book is not found.")

    override fun getTotal(): Long = bookMapper.total()

    override fun findAll(page: Pageable): List<Book> {
        println("${page.offset}, ${page.pageNumber}")
        return bookMapper
            .findAll(
                offset = page.offset,
                limit = page.pageSize.toLong(),
            ).map {
                it.toDomain()
            }
    }
}
