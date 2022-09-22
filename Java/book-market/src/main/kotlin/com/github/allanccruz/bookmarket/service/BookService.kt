package com.github.allanccruz.bookmarket.service

import com.github.allanccruz.bookmarket.enums.BookStatus
import com.github.allanccruz.bookmarket.enums.Errors
import com.github.allanccruz.bookmarket.exception.NotFoundException
import com.github.allanccruz.bookmarket.model.BookModel
import com.github.allanccruz.bookmarket.model.CustomerModel
import com.github.allanccruz.bookmarket.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {

    fun save(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAllBooks(pageable: Pageable): Page<BookModel> {
        return bookRepository.findAll(pageable)
    }

    fun findActives(pageable: Pageable): Page<BookModel> {
        return bookRepository.findByStatus(BookStatus.ACTIVE, pageable)
    }

    fun getById(id: Int): BookModel {
       return bookRepository.findById(id).orElseThrow{ NotFoundException(Errors.ML101.message.format(id), Errors.ML101.code) }
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