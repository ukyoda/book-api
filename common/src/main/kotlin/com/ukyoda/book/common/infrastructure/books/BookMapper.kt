package com.ukyoda.book.common.infrastructure.books

import com.ukyoda.book.common.infrastructure.books.dto.BookDto
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select

@Mapper
interface BookMapper {
    @Insert(
        """
        INSERT INTO books (
          title,
          isbn,
          description,
          small_image_url,
          medium_image_url,
          large_image_url,
          authors,
          publisher,
          published_date,
          created_at,
          updated_at
        ) VALUES (
          #{bookDto.title},
          #{bookDto.isbn},
          #{bookDto.description},
          #{bookDto.smallImageUrl},
          #{bookDto.mediumImageUrl},
          #{bookDto.largeImageUrl},
          #{bookDto.authors},
          #{bookDto.publisher},
          #{bookDto.publishedDate},
          #{createdAt},
          #{updatedAt}
        )
        """,
    )
    @Options(
        useGeneratedKeys = true,
        keyProperty = "bookDto.id",
    )
    fun insert(
        bookDto: BookDto,
        createdAt: Long,
        updatedAt: Long,
    )

    @Select(
        """
        SELECT 
            * 
        FROM 
            books
        WHERE
            id = #{id}
        """,
    )
    fun findById(bookId: Long): BookDto?

    @Select(
        """
        SELECT 
            * 
        FROM 
            books
        LIMIT 
            #{offset} #{limit}
        """,
    )
    fun findAll(
        offset: Long,
        limit: Long,
    ): List<BookDto>

    @Select(
        """
        SELECT
            count(*)
        FROM 
            books
        """,
    )
    fun total(): Long

    @Select(
        """
        SELECT 
            * 
        FROM 
            books
        WHERE
            id in
            <foreach item="id" collection="bookIds" open="(" separator="," close=")">
                #{id}
            </foreach>
        """,
    )
    fun findByIds(bookIds: List<Long>): List<BookDto>
}
