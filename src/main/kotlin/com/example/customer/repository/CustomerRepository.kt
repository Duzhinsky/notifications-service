package com.example.customer.repository

import com.example.customer.model.CustomerEntity

interface CustomerRepository {
    suspend fun findAll(): List<CustomerEntity>
    suspend fun findById(id: Int): CustomerEntity?
    suspend fun save(customer: CustomerEntity): Boolean
    suspend fun deleteById(id: Int): Long
}