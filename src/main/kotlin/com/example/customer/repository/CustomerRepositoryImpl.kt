package com.example.customer.repository

import com.example.customer.model.CustomerEntity
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.eq
import org.litote.kmongo.reactivestreams.KMongo

const val uri = "mongodb://docker:mongopw@localhost:49155"

class CustomerRepositoryImpl : CustomerRepository {

    private val mongoClient: CoroutineClient = KMongo.createClient(uri).coroutine

    override suspend fun findAll(): List<CustomerEntity> {
        return collection().find().toList()
    }

    override suspend fun findById(id: Int): CustomerEntity? {
        val found = collection().find(CustomerEntity::id eq id).toList()
        return when(found.size) {
            0 -> null
            1 -> found[0]
            else -> throw RuntimeException()
        }
    }

    override suspend fun save(customer: CustomerEntity): Boolean {
        return collection().save(customer) != null
    }

    override suspend fun deleteById(id: Int): Long {
        return collection().deleteMany(CustomerEntity::id eq id).deletedCount
    }

    private fun collection() =
        mongoClient
            .getDatabase("ktortest")
            .getCollection<CustomerEntity>("customers")
}