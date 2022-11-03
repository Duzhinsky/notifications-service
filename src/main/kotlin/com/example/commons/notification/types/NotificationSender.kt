package com.example.commons.notification.types

interface NotificationSender<in T> {
    fun sendNotification(notification: T)
}