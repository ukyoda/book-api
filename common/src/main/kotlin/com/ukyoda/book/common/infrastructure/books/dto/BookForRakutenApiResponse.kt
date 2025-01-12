package com.ukyoda.book.common.infrastructure.books.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.ukyoda.book.common.domain.books.model.Author
import com.ukyoda.book.common.domain.books.model.Book
import java.text.SimpleDateFormat

@JsonIgnoreProperties(ignoreUnknown = true)
data class BookForRakutenApiResponse(
    @JsonProperty("Items")
    val items: List<ItemWrapper>,
) {
    fun toDomain(): List<Book> =
        items.map {
            Book(
                title = it.item.title,
                isbn = it.item.isbn,
                description = it.item.itemCaption,
                smallImageUrl = it.item.smallImageUrl,
                mediumImageUrl = it.item.mediumImageUrl,
                largeImageUrl = it.item.largeImageUrl,
                publisher = it.item.publisherName,
                publishedDate =
                    try {
                        SimpleDateFormat("yyyy年MM月dd日")
                            .parse(
                                it.item.salesDate
                                    .replace("頃", ""),
                            ).time
                    } catch (e: Exception) {
                        null
                    },
                authors =
                    it.item.author.let { str ->
                        when (str) {
                            "" -> emptyList()
                            else ->
                                str
                                    .split("/")
                                    .toList()
                                    .map { name ->
                                        Author(name = name)
                                    }
                        }
                    },
            )
        }

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class ItemWrapper(
        @JsonProperty("Item")
        val item: Item,
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Item(
        @JsonProperty("title")
        val title: String,
        @JsonProperty("isbn")
        val isbn: String,
        @JsonProperty("itemCaption")
        val itemCaption: String,
        @JsonProperty("smallImageUrl")
        val smallImageUrl: String,
        @JsonProperty("mediumImageUrl")
        val mediumImageUrl: String,
        @JsonProperty("largeImageUrl")
        val largeImageUrl: String,
        @JsonProperty("publisherName")
        val publisherName: String,
        @JsonProperty("salesDate")
        val salesDate: String,
        @JsonProperty("author")
        val author: String,
    )
}
