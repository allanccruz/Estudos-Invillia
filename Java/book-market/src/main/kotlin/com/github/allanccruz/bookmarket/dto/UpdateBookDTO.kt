package com.github.allanccruz.bookmarket.dto

import java.math.BigDecimal

data class UpdateBookDTO (
    var name: String?,

    var price: BigDecimal?
)