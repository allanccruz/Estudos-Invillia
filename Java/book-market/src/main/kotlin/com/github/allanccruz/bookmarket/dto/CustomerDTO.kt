package com.github.allanccruz.bookmarket.dto

import com.github.allanccruz.bookmarket.validation.EmailAvailable
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class CustomerDTO (

    @field: NotEmpty(message = "Name must not be empty.")
    var name: String,

    @field:Email(message = "E-mail must be valid.")
    @EmailAvailable
    var email: String
)