package com.github.allanccruz.bookmarket.controllers

import com.github.allanccruz.bookmarket.dto.BookDTO
import com.github.allanccruz.bookmarket.dto.UpdateBookDTO
import com.github.allanccruz.bookmarket.extension.toBookModel
import com.github.allanccruz.bookmarket.model.BookModel
import com.github.allanccruz.bookmarket.service.BookService
import com.github.allanccruz.bookmarket.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/book-market/books")
class BookController (
    val bookService: BookService,
    val customerService: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveBook(@RequestBody bookDTO: BookDTO) {
        val customer = customerService.getById(bookDTO.customerId)
        bookService.save(bookDTO.toBookModel(customer))
    }

    @GetMapping
    fun getAllBooks(@RequestParam name: String?): List<BookModel> {
        return bookService.findAllBooks()
    }

    @GetMapping("/actives")
    fun getActivesBooks(): List<BookModel> {
        return bookService.findActives()
    }

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: Int): BookModel {
        return bookService.getById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateBook(@PathVariable id: Int, @RequestBody updateBookDTO: UpdateBookDTO) {
        val book = bookService.getById(id)
        bookService.updateBook(updateBookDTO.toBookModel(book))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(@PathVariable id: Int) {
        bookService.deleteBook(id)
    }
}