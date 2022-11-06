package com.example.notification.core.model

enum class NotificationStatus {
    CREATED,
    SENT,
    DELIVERED,
    FAILED;

    var message: String? = null
}