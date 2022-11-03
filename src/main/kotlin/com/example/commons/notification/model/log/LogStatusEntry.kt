package com.example.commons.notification.model.log

import com.example.commons.notification.model.NotificationStatus
import java.time.LocalDateTime

data class LogStatusEntry(
    var time: LocalDateTime,
    var status: NotificationStatus,
    var failureMessage: String?
)
