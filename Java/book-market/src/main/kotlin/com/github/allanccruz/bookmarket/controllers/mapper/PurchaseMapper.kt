package com.github.allanccruz.bookmarket.controllers.mapper

import com.github.allanccruz.bookmarket.dto.PurchaseDTO
import com.github.allanccruz.bookmarket.model.PurchaseModel
import com.github.allanccruz.bookmarket.service.BookService
import com.github.allanccruz.bookmarket.service.CustomerService
import org.springframework.stereotype.Component

@Component
class PurchaseMapper(
    private val bookService: BookService,
    private val customerService: CustomerService
) {

    fun toPurchaseModel(purchaseDTO: PurchaseDTO): PurchaseModel {
        val customer = customerService.getById(purchaseDTO.customerId)
        val books = bookService.getAllByIds(purchaseDTO.bookIds)

        return PurchaseModel(
            customer = customer,
            books = books.toMutableList(),
            price = books.sumOf { it.price }
        )
    }
}