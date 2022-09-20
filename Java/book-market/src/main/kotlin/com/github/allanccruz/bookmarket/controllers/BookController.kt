package com.github.allanccruz.bookmarket.controllers

import com.github.allanccruz.bookmarket.dto.BookDTO
import com.github.allanccruz.bookmarket.extension.toBookModel
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

//    @GetMapping
//    fun getAllCustomers(@RequestParam name: String?): List<CustomerModel> {
//        return customerService.getAllCustomers(name)
//    }
//
//    @GetMapping("/{id}")
//    fun getCustomer(@PathVariable id: Int): CustomerModel {
//        return customerService.getById(id)
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveBook(@RequestBody bookDTO: BookDTO) {
        val customer = customerService.getById(bookDTO.customerId)
        bookService.save(bookDTO.toBookModel(customer))
    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    fun updateCustomer(@PathVariable id: Int, @RequestBody customer: CustomerDTO) {
//        customerService.updateCustomer(id, customer.toCustomerModel())
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    fun deleteCustomer(@PathVariable id: Int) {
//        customerService.deleteCustomer(id)
//    }
}