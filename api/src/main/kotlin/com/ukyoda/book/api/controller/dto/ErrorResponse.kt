package com.ukyoda.book.api.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper

data class ErrorResponse(
    @JsonProperty("code")
    val code: Int,
    @JsonProperty("reason")
    val reason: String,
    @JsonProperty("message")
    val message: String? = null,
) {
    fun toJson(): String =
        ObjectMapper()
            .writerWithDefaultPrettyPrinter()
            .writeValueAsString(this)
}
