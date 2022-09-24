package com.github.allanccruz.bookmarket.events.listeners

import com.github.allanccruz.bookmarket.events.PurchaseEvent
import com.github.allanccruz.bookmarket.service.BookService
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class UpdateSoldBookListener(
    val bookService: BookService
) {

    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {
        bookService.purchase(purchaseEvent.purchaseModel.books)
    }
}