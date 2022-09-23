package com.github.allanccruz.bookmarket.service

import com.github.allanccruz.bookmarket.enums.CustomerStatus
import com.github.allanccruz.bookmarket.enums.Errors
import com.github.allanccruz.bookmarket.exception.NotFoundException
import com.github.allanccruz.bookmarket.model.CustomerModel
import com.github.allanccruz.bookmarket.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService (
    val customerRepository: CustomerRepository,
    val bookService: BookService
) {

    fun getAllCustomers(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll()
    }

    fun getById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow{ NotFoundException(Errors.ML201.message.format(id), Errors.ML201.code) }
    }

    fun saveCustomer(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun updateCustomer(id: Int, customer: CustomerModel) {
        if(!customerRepository.existsById(customer.id!!)) {
            throw Exception("Customer not found.")
        }
        customerRepository.save(customer)
    }

    fun deleteCustomer(id: Int) {
        val customer = getById(id)
        bookService.deleteByCustomer(customer)

        customer.status = CustomerStatus.INACTIVE
        customerRepository.save(customer)
    }

    fun emailAvailable(email: String): Boolean {
        return !customerRepository.existsByEmail(email)
    }
}