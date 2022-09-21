package com.github.allanccruz.bookmarket.repository

import com.github.allanccruz.bookmarket.BookStatus
import com.github.allanccruz.bookmarket.model.BookModel
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<BookModel, Int> {
    fun findByStatus(status: BookStatus): List<BookModel>
}