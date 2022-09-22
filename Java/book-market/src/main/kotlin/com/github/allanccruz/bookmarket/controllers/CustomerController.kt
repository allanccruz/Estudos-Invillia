package com.github.allanccruz.bookmarket.controllers

import com.github.allanccruz.bookmarket.controllers.response.CustomerResponse
import com.github.allanccruz.bookmarket.dto.CustomerDTO
import com.github.allanccruz.bookmarket.dto.UpdateCustomerDTO
import com.github.allanccruz.bookmarket.extension.toCustomerModel
import com.github.allanccruz.bookmarket.extension.toResponse
import com.github.allanccruz.bookmarket.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/book-market/customers")
class CustomerController (
    val customerService: CustomerService
){

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveCustomer(@RequestBody customerDTO: CustomerDTO) {
        customerService.saveCustomer(customerDTO.toCustomerModel())
    }

    @GetMapping
    fun getAllCustomers(@RequestParam name: String?): List<CustomerResponse> {
        return customerService.getAllCustomers(name).map{it.toResponse()}
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerResponse {
        return customerService.getById(id).toResponse()
    }

   @PutMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: Int, @RequestBody updateCustomerDTO: UpdateCustomerDTO) {
       val customer = customerService.getById(id)
       customerService.updateCustomer(id, updateCustomerDTO.toCustomerModel(customer))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Int) {
        customerService.deleteCustomer(id)
    }
}