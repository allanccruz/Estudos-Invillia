package com.github.allanccruz.bookmarket.extension

import com.github.allanccruz.bookmarket.dto.CustomerDTO
import com.github.allanccruz.bookmarket.model.CustomerModel

fun CustomerDTO.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}