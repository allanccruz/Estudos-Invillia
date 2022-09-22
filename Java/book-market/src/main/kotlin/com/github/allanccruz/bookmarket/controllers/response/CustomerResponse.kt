package com.github.allanccruz.bookmarket.controllers.response

import com.github.allanccruz.bookmarket.enums.CustomerStatus

data class CustomerResponse (
    var id: Int? = null,

    var name: String,

    var email: String,

    var status: CustomerStatus
)
