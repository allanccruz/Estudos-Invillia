package com.github.allanccruz.bookmarket.service

import com.github.allanccruz.bookmarket.model.BookModel
import com.github.allanccruz.bookmarket.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {

    fun save(book: BookModel) {
        bookRepository.save(book)
    }
}
