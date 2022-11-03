package com.example.commons.notification.repository

import com.example.commons.notification.model.log.LogEntity

interface VerificationRepository {

    suspend fun save(verificationEntity: LogEntity)
    suspend fun findAllVerifications(customerId: Int, target: String): List<LogEntity>
}