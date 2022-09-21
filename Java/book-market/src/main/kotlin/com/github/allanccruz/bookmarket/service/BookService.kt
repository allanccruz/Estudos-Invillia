package com.github.allanccruz.bookmarket.service

import com.github.allanccruz.bookmarket.BookStatus
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

    fun findAllBooks(): List<BookModel> {
        return bookRepository.findAll()
    }

    fun findActives(): List<BookModel> {
        return bookRepository.findByStatus(BookStatus.ATIVO)
    }

    fun getById(id: Int): BookModel {
       return bookRepository.findById(id).orElseThrow()
    }

    fun deleteBook(id: Int) {
        val book = getById(id)
        book.status = BookStatus.CANCELADO
        updateBook(book)
    }

    fun updateBook(book: BookModel) {
        bookRepository.save(book)
    }
}