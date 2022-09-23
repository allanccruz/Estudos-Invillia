package com.github.allanccruz.bookmarket.dto

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class BookDTO (

    @field: NotEmpty(message = "Name must not be empty.")
    var name: String,

    @field: NotNull(message = "Price must not be empty.")
    var price: BigDecimal,

    @JsonAlias("customer_id")
    var customerId: Int
)
