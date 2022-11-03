package com.example.commons.notification.service

import com.example.commons.notification.model.Notification
import com.example.commons.notification.repository.VerificationRepository
import com.example.commons.notification.types.NotificationSender

class NotificationServiceImpl(private val verificationRepository: VerificationRepository) : NotificationService {

    override suspend fun sendNotification(sender: NotificationSender<in Notification>) {
        TODO("Not yet implemented")
    }
}