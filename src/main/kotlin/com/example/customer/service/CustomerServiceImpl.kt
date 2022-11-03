package com.example.customer.service

import com.example.customer.model.CustomerDto
import com.example.customer.model.toDto
import com.example.customer.model.toEntity
import com.example.customer.repository.CustomerRepository
import java.time.LocalDateTime

class CustomerServiceImpl(
    private val repository: CustomerRepository,
    private val emailService: CustomerService
    ) : CustomerService {

    override suspend fun findAll(): List<CustomerDto> {
        return repository.findAll().map { it.toDto() }
    }

    override suspend fun findById(id: Int): CustomerDto? {
        return repository.findById(id)?.toDto()
    }

    override suspend fun add(customer: CustomerDto): Boolean {
        val newCustomer = customer.toEntity()
        newCustomer.lastModified = LocalDateTime.now()
        return repository.save(newCustomer)
    }

    override suspend fun changeEmailVerification(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun changeEmail(id: Int, email: String, verification: String): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteById(id: Int): Long {
        return repository.deleteById(id)
    }
}