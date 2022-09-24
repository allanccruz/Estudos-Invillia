package com.github.allanccruz.bookmarket.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class PurchaseDTO (

    @field: NotNull
    @field: Positive
    val customerId: Int,

    @field: NotNull
    val bookIds: Set<Int>
)