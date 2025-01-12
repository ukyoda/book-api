package com.ukyoda.book.api.controller.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ErrorResponse(
    @JsonProperty("code")
    val code: Int,
    @JsonProperty("reason")
    val reason: String,
    @JsonProperty("message")
    val message: String? = null,
)
