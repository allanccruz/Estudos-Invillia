package com.github.allanccruz.bookmarket.service

import com.github.allanccruz.bookmarket.model.PurchaseModel
import com.github.allanccruz.bookmarket.repository.PurchaseRepository
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    val purchaseRepository: PurchaseRepository
) {

    fun create(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }
}
