package com.github.allanccruz.bookmarket.repository

import com.github.allanccruz.bookmarket.model.PurchaseModel
import org.springframework.data.jpa.repository.JpaRepository

interface PurchaseRepository : JpaRepository<PurchaseModel, Int> {

}
