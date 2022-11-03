package com.example.commons.notification.service

import com.example.commons.notification.model.Notification
import com.example.commons.notification.types.NotificationSender

interface NotificationService {
    suspend fun sendNotification(sender: NotificationSender<in Notification>)
}