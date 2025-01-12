package com.ukyoda.book.common.infrastructure.books

import com.ukyoda.book.common.infrastructure.books.dto.BookDto
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper

@Mapper
interface BookMapper {
    @Insert(
        """
        insert into books (
          title,
          isbn,
          description,
          small_image_url,
          medium_image_url,
          large_image_url,
          publisher,
          published_date,
          created_at,
          updated_at
        ) values (
          #{bookDto.title},
          #{bookDto.isbn},
          #{bookDto.description},
          #{bookDto.smallImageUrl},
          #{bookDto.mediumImageUrl},
          #{bookDto.largeImageUrl},
          #{bookDto.publisher},
          #{bookDto.publishedDate},
          #{createdAt},
          #{updatedAt}
        )
        """,
    )
    fun insert(
        bookDto: BookDto,
        createdAt: Long,
        updatedAt: Long,
    ): Long
}
