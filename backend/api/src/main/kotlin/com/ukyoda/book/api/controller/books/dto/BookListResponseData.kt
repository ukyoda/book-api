package com.ukyoda.book.api.controller.books.dto

import com.ukyoda.book.usecase.books.model.BookList

data class BookListResponseData(
    val books: List<BookResponseData>,
    val total: Long,
    val page: Int,
) {
    companion object {
        fun fromBookList(bookList: BookList): BookListResponseData =
            BookListResponseData(
                books =
                    bookList
                        .books
                        .map {
                            BookResponseData.fromDomain(it)
                        },
                total = bookList.total,
                page = bookList.page,
            )
    }
}
