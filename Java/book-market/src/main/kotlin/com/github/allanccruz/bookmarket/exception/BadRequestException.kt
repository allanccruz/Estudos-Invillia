package com.github.allanccruz.bookmarket.exception

class BadRequestException(override val message: String, val errorCode: String): Exception() {

}