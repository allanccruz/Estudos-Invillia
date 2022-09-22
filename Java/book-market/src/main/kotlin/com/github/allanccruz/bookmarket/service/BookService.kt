package com.github.allanccruz.bookmarket.service

import com.github.allanccruz.bookmarket.enums.BookStatus
import com.github.allanccruz.bookmarket.model.BookModel
import com.github.allanccruz.bookmarket.model.CustomerModel
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
        return bookRepository.findByStatus(BookStatus.ACTIVE)
    }

    fun getById(id: Int): BookModel {
       return bookRepository.findById(id).orElseThrow()
    }

    fun deleteBook(id: Int) {
        val book = getById(id)
        book.status = BookStatus.CANCELED
        updateBook(book)
    }

    fun updateBook(book: BookModel) {
        bookRepository.save(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = bookRepository.findByCustomer(customer)
        for (book in books) {
            book.status = BookStatus.DELETED
        }
        bookRepository.saveAll(books)
    }
}