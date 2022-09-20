package com.github.allanccruz.bookmarket.controllers

import com.github.allanccruz.bookmarket.dto.CustomerDTO
import com.github.allanccruz.bookmarket.model.CustomerModel
import com.github.allanccruz.bookmarket.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/book-market/customers")
class CustomerController (
    val customerService: CustomerService
){


    @GetMapping
    fun getAllCustomers(@RequestParam name: String?): List<CustomerModel> {
        return customerService.getAllCustomers(name)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customerService.getCustomer(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveCustomer(@RequestBody customer: CustomerDTO) {
        customerService.saveCustomer(customer)
    }

   @PutMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: String, @RequestBody customer: CustomerDTO) {
        customerService.updateCustomer(id, customer)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: String) {
        customerService.deleteCustomer(id)
    }
}