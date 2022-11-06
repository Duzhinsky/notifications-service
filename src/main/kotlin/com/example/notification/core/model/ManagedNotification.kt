package com.example.notification.core.model

import com.example.notification.core.NotificationManager

class ManagedNotification(
    val notification: Notification,
    val retryLauncher: (Notification) -> Unit,
    val manager: NotificationManager
) {

    var status: NotificationStatus = NotificationStatus.CREATED
        set(value) {
            field = value
            onUpdate()
        }

    private fun onUpdate() {
        manager.onUpdate(this)
    }
}