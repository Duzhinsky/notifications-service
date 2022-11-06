package com.example.notification.core

import com.example.notification.core.model.ManagedNotification
import com.example.notification.core.model.NotificationStatus

class BaseNotificationManager : NotificationManager {

    override fun onUpdate(managedNotification: ManagedNotification) {
        println(managedNotification.status.toString())
        if (managedNotification.status == NotificationStatus.FAILED) {
            managedNotification.status.message?.let{ println(it) }
            managedNotification.notification.ifFails?.let {
                managedNotification.retryLauncher(it)
            }
        }
    }
}