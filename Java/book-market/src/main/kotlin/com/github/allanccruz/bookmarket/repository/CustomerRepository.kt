package com.github.allanccruz.bookmarket.repository

import com.github.allanccruz.bookmarket.model.CustomerModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<CustomerModel, Int> {

    fun findByNameContaining(name: String): List<CustomerModel>
}