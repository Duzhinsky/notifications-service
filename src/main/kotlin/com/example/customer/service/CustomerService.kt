package com.example.customer.service

import com.example.customer.model.CustomerDto

interface CustomerService {
    suspend fun findAll(): List<CustomerDto>
    suspend fun findById(id: Int): CustomerDto?
    suspend fun add(customer: CustomerDto): Boolean
    suspend fun changeEmailVerification(id: Int): Boolean
    suspend fun changeEmail(id: Int, email: String, verification: String): Boolean
    suspend fun deleteById(id: Int): Long
}