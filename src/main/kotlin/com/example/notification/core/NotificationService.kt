package com.example.notification.core

import com.example.notification.core.model.Notification

interface NotificationService {

    suspend fun sendNotification(notification: Notification)
}