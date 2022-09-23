package com.github.allanccruz.bookmarket.controllers

import com.github.allanccruz.bookmarket.controllers.response.BookResponse
import com.github.allanccruz.bookmarket.dto.BookDTO
import com.github.allanccruz.bookmarket.dto.UpdateBookDTO
import com.github.allanccruz.bookmarket.extension.toBookModel
import com.github.allanccruz.bookmarket.extension.toResponse
import com.github.allanccruz.bookmarket.service.BookService
import com.github.allanccruz.bookmarket.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("api/book-market/books")
class BookController (
    val bookService: BookService,
    val customerService: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveBook(@RequestBody @Valid bookDTO: BookDTO) {
        val customer = customerService.getById(bookDTO.customerId)
        bookService.save(bookDTO.toBookModel(customer))
    }

    @GetMapping
    fun getAllBooks(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return bookService.findAllBooks(pageable).map {it.toResponse()}
    }

    @GetMapping("/actives")
    fun getActivesBooks(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return bookService.findActives(pageable).map {it.toResponse()}
    }

    @GetMapping("/{id}")
    fun getBook(@PathVariable id: Int): BookResponse {
        return bookService.getById(id).toResponse()
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