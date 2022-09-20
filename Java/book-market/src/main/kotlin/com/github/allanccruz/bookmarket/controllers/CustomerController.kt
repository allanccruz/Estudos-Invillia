package com.github.allanccruz.bookmarket.controllers

import com.github.allanccruz.bookmarket.dto.CustomerDTO
import com.github.allanccruz.bookmarket.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/book-market/customers")
class CustomerController {

    val customers = mutableListOf<CustomerModel>()

    @GetMapping
    fun getAllCustomers(@RequestParam name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customers.filter { it.id == id }.first()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveCustomer(@RequestBody customer: CustomerDTO) {
        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id.toInt() + 1
        }.toString()

        customers.add(CustomerModel(id, customer.name, customer.email))
    }

   @PutMapping("/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCustomer(@PathVariable id: String, @RequestBody customer: CustomerDTO) {
        customers.filter { it.id == id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: String) {
        customers.removeIf { it.id == id }
    }
}