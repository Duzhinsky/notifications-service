package com.example.notification.senders.email

import com.example.notification.core.model.Notification
import org.apache.commons.mail.Email

class EmailNotification(
    val email: Email,
    override val ifFails: Notification? = null
    ) : Notification(ifFails) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EmailNotification

        if (email != other.email) return false
        if (ifFails != other.ifFails) return false

        return true
    }

    override fun hashCode(): Int {
        var result = email.hashCode()
        result = 31 * result + (ifFails?.hashCode() ?: 0)
        return result
    }
}