package com.github.allanccruz.bookmarket.extension

import com.github.allanccruz.bookmarket.controllers.response.BookResponse
import com.github.allanccruz.bookmarket.controllers.response.CustomerResponse
import com.github.allanccruz.bookmarket.enums.BookStatus
import com.github.allanccruz.bookmarket.dto.BookDTO
import com.github.allanccruz.bookmarket.dto.CustomerDTO
import com.github.allanccruz.bookmarket.dto.UpdateBookDTO
import com.github.allanccruz.bookmarket.dto.UpdateCustomerDTO
import com.github.allanccruz.bookmarket.enums.CustomerStatus
import com.github.allanccruz.bookmarket.model.BookModel
import com.github.allanccruz.bookmarket.model.CustomerModel

fun CustomerDTO.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email, status = CustomerStatus.ACTIVE)
}

fun UpdateCustomerDTO.toCustomerModel(previousValue: CustomerModel): CustomerModel {
    return CustomerModel(id = previousValue.id, name = this.name, email = this.email, status = previousValue.status)
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(id = this.id, name = this.name, email = this.email, status = this.status)
}

fun BookDTO.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ACTIVE,
        customer = customer
    )
}

fun UpdateBookDTO.toBookModel(previousValue: BookModel): BookModel {
    return BookModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}

fun BookModel.toResponse(): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        customer = this.customer,
        status = this.status
    )
}