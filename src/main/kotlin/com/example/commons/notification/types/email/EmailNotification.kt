package com.example.commons.notification.types.email

import com.example.commons.notification.model.DestinationType
import com.example.commons.notification.model.Notification

data class EmailNotification(
    var email: String,
    var template: String,
    var templateMap: Map<String, String>
    ) : Notification(DestinationType.EMAIL)