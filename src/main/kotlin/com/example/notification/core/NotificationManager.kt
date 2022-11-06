package com.example.notification.core

import com.example.notification.core.model.ManagedNotification

interface NotificationManager {

    fun onUpdate(managedNotification: ManagedNotification)
}