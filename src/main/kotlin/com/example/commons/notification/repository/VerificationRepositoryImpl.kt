package com.example.commons.notification.repository

import com.example.commons.notification.model.log.LogEntity
import com.example.customer.repository.uri
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

const val uri = "mongodb://docker:mongopw@localhost:49155"

class VerificationRepositoryImpl : VerificationRepository {

    private val mongoClient: CoroutineClient = KMongo.createClient(uri).coroutine

    override suspend fun save(verificationEntity: LogEntity) {
        collection().save(verificationEntity)
    }

    override suspend fun findAllVerifications(customerId: Int, target: String): List<LogEntity> {
        return collection()
            .find("{customerId: $customerId, target: $target, validTill: { \$gte: \$\$NOW }}")
            .toList()
    }

    private fun collection() =
        mongoClient
            .getDatabase("ktortest")
            .getCollection<LogEntity>("verifications")
}