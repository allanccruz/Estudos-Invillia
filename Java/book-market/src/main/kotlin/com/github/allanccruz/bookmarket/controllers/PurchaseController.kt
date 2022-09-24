package com.github.allanccruz.bookmarket.controllers

import com.github.allanccruz.bookmarket.controllers.mapper.PurchaseMapper
import com.github.allanccruz.bookmarket.dto.PurchaseDTO
import com.github.allanccruz.bookmarket.service.PurchaseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/book-market/purchases")
class PurchaseController(
    private val purchaseService: PurchaseService,
    private val purchaseMapper: PurchaseMapper
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun purchase(@RequestBody purchaseDTO: PurchaseDTO) {
        purchaseService.create(purchaseMapper.toPurchaseModel(purchaseDTO))
    }
}