package com.example.notification.senders.sms

import com.example.notification.core.model.Notification

 class SmsNotification(
    var phoneNumber: String,
    var message: String,
    override val ifFails: Notification? = null
) : Notification(ifFails) {

     override fun equals(other: Any?): Boolean {
         if (this === other) return true
         if (javaClass != other?.javaClass) return false

         other as SmsNotification

         if (phoneNumber != other.phoneNumber) return false
         if (message != other.message) return false
         if (ifFails != other.ifFails) return false

         return true
     }

     override fun hashCode(): Int {
         var result = phoneNumber.hashCode()
         result = 31 * result + message.hashCode()
         result = 31 * result + (ifFails?.hashCode() ?: 0)
         return result
     }
 }
