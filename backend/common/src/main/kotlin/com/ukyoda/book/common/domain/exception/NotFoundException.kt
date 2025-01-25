package com.ukyoda.book.common.domain.exception

class NotFoundException : RuntimeException {
    constructor(message: String) : super(message)
}
