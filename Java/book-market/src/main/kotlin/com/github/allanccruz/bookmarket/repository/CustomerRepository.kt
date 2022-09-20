package com.github.allanccruz.bookmarket.repository

import com.github.allanccruz.bookmarket.model.CustomerModel
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<CustomerModel, Int> {

    fun findByNameContaining(name: String): List<CustomerModel>
}