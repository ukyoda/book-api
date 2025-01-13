package com.ukyoda.book.usecase.books.model

import com.ukyoda.book.common.domain.books.model.Book

data class BookList(
    val books: List<Book>,
    val total: Long,
    val page: Int,
)
