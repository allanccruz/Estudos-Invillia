package com.github.allanccruz.bookmarket.repository

import com.github.allanccruz.bookmarket.enums.BookStatus
import com.github.allanccruz.bookmarket.model.BookModel
import com.github.allanccruz.bookmarket.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<BookModel, Int> {
    fun findByStatus(status: BookStatus, pageable: Pageable): Page<BookModel>
    fun findByCustomer(customer: CustomerModel): List<BookModel>
}