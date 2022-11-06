package com.example.notification.core

import com.example.notification.core.model.Notification
import com.example.notification.core.model.ManagedNotification

interface NotificationSender {

    /**
     * @throws IllegalArgumentException if the notification type is not acceptable
     * @throws NotificationSendingException if it is failed to send a notification
     */
    suspend fun sendNotification(managedNotification: ManagedNotification)
    fun isNotificationAcceptable(notification: Notification): Boolean
}