package com.github.allanccruz.bookmarket.repository

import com.github.allanccruz.bookmarket.enums.BookStatus
import com.github.allanccruz.bookmarket.model.BookModel
import com.github.allanccruz.bookmarket.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<BookModel, Int> {
    fun findByStatus(status: BookStatus, pageable: Pageable): Page<BookModel>
    fun findByCustomer(customer: CustomerModel): List<BookModel>
}