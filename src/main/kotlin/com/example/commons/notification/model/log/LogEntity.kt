package com.example.commons.notification.model.log

import com.example.commons.notification.model.Notification

data class LogEntity(
    var id: Long,
    var notification: Notification,
    var statusLog: MutableList<LogStatusEntry>
)