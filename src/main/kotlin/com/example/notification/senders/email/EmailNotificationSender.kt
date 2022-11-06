package com.example.notification.senders.email

import com.example.notification.core.NotificationSender
import com.example.notification.core.model.ManagedNotification
import com.example.notification.core.model.Notification
import com.example.notification.core.model.NotificationStatus

class EmailNotificationSender : NotificationSender {

    override suspend fun sendNotification(managedNotification: ManagedNotification) {
        val notification = managedNotification.notification
        if(notification !is EmailNotification) throw IllegalArgumentException()
        try {
            notification.email.send()
            managedNotification.status = NotificationStatus.DELIVERED
        } catch (ex: Exception) {
            managedNotification.status = NotificationStatus.FAILED
            managedNotification.status.message = ex.message
        }
    }

    override fun isNotificationAcceptable(notification: Notification): Boolean {
        return notification is EmailNotification
    }
}