package com.example.notification.core

import com.example.notification.core.model.*
import kotlinx.coroutines.*

class BaseNotificationService(private val notificationManager: NotificationManager) :
    NotificationService {

    private val senders = mutableListOf<NotificationSender>()

    override suspend fun sendNotification(notification: Notification) {
        val sender = senders
            .find { it.isNotificationAcceptable(notification) }
            ?: throw IllegalStateException(
                "There is no registered sender to send the notification"
            )
        val managedNotification = ManagedNotification(notification, this::launchFailed, notificationManager)
        coroutineScope {
            launch {
                sender.sendNotification(managedNotification)
            }
        }
    }

    private fun launchFailed(notification: Notification) {
        runBlocking { sendNotification(notification) }
    }

    fun register(notificationSender: NotificationSender) {
        senders.add(notificationSender)
    }
}