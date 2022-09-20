package com.github.allanccruz.bookmarket.service

import com.github.allanccruz.bookmarket.model.CustomerModel
import com.github.allanccruz.bookmarket.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService (
    val customerRepository: CustomerRepository
) {

    fun getAllCustomers(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll()
    }

    fun getCustomer(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun saveCustomer(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun updateCustomer(id: Int, customer: CustomerModel) {
        customer.id = id

        if(!customerRepository.existsById(customer.id!!)) {
            throw Exception("Customer not found.")
        }
        customerRepository.save(customer)
    }

    fun deleteCustomer(id: Int) {
        if(!customerRepository.existsById(id)) {
            throw Exception("Customer not found.")
        }
        customerRepository.deleteById(id)
    }
}