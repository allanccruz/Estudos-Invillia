package com.github.allanccruz.bookmarket.controllers.response

import com.github.allanccruz.bookmarket.enums.BookStatus
import com.github.allanccruz.bookmarket.model.CustomerModel
import java.math.BigDecimal

class BookResponse (
    var id: Int? = null,

    var name: String,

    var price: BigDecimal,

    var customer: CustomerModel? = null,

    var status: BookStatus? = null
)