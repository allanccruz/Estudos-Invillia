package com.github.allanccruz.bookmarket.dto

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class BookDTO (
    var name: String,

    var price: BigDecimal,

    @JsonAlias("customer_id")
    var customerId: Int
)
