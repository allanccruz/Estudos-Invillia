package com.github.allanccruz.bookmarket.extension

import com.github.allanccruz.bookmarket.BookStatus
import com.github.allanccruz.bookmarket.dto.BookDTO
import com.github.allanccruz.bookmarket.dto.CustomerDTO
import com.github.allanccruz.bookmarket.model.BookModel
import com.github.allanccruz.bookmarket.model.CustomerModel

fun CustomerDTO.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun BookDTO.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}