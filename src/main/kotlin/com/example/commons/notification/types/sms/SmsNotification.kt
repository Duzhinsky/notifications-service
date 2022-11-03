package com.example.commons.notification.types.sms

import com.example.commons.notification.model.DestinationType
import com.example.commons.notification.model.Notification

data class SmsNotification(
    var phoneNumber: String,
    var message: String
) : Notification(DestinationType.SMS)
