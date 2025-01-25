package com.ukyoda.book.common.infrastructure.books

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.ukyoda.book.common.domain.books.model.Book
import com.ukyoda.book.common.domain.books.repository.BookApiRepository
import com.ukyoda.book.common.infrastructure.books.dto.BookForRakutenApiResponse
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okio.IOException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Repository
import java.net.URLEncoder

@Repository
class BookApiRepositoryImpl(
    @Value("\${third_api.rakuten.app_id}") private val appId: String,
) : BookApiRepository {
    companion object {
        private val client: OkHttpClient = OkHttpClient()
        private val baseUrl: String = "https://app.rakuten.co.jp/services/api/BooksBook/Search/20170404"
    }

    override fun findByTitle(title: String): List<Book> {
        val encodedTitle = URLEncoder.encode(title, "UTF-8")
        return getRequest(
            "$baseUrl?applicationId=$appId&format=json&title=$encodedTitle",
        ).let {
            it.body?.string()?.let { body ->
                ObjectMapper()
                    .readValue(body, BookForRakutenApiResponse::class.java)
                    .toDomain()
            } ?: emptyList()
        }
    }

    override fun findByIsbn(isbn: String): Book? =
        getRequest(
            "$baseUrl?applicationId=$appId&format=json&isbn=$isbn",
        ).let {
            it.body?.string()?.let { body ->
                ObjectMapper()
                    .readValue(body, BookForRakutenApiResponse::class.java)
                    .toDomain()
                    .takeIf { data -> data.isNotEmpty() }
                    ?.first()
            }
        }

    override fun findByAuthor(author: String): List<Book> {
        val encodedAuthor = URLEncoder.encode(author, "UTF-8")
        return getRequest(
            "$baseUrl?applicationId=$appId&format=json&author=$encodedAuthor",
        ).let {
            it.body?.string()?.let { body ->
                ObjectMapper()
                    .readValue(body, BookForRakutenApiResponse::class.java)
                    .toDomain()
            } ?: emptyList()
        }
    }

    private fun getRequest(url: String): Response {
        val request =
            Request
                .Builder()
                .url(url)
                .get()
                .build()
        val response = client.newCall(request).execute()
        if (!response.isSuccessful) {
            throw IOException("Request Failed")
        }
        return response
    }
}
