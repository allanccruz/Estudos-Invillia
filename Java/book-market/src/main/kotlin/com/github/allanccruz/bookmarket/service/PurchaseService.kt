package com.github.allanccruz.bookmarket.service

import com.github.allanccruz.bookmarket.events.PurchaseEvent
import com.github.allanccruz.bookmarket.model.PurchaseModel
import com.github.allanccruz.bookmarket.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    val purchaseRepository: PurchaseRepository,
    val applicationEventPublisher: ApplicationEventPublisher
) {

    fun create(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)

        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel))
    }
}
